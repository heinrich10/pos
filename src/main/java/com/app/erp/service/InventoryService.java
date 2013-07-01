package com.app.erp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.app.erp.mapper.InventoryMapper;
import com.app.erp.mapper.UnitMapper;
import com.app.erp.model.InventoryActive;
import com.app.erp.model.InventoryActiveList;
import com.app.erp.model.InventoryPending;
import com.app.erp.model.InventoryPendingList;
import com.app.erp.model.UnitAndPostUnit;

public class InventoryService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 965620516500933416L;
	
	@Inject
	private transient InventoryMapper inventoryMapper;
	@Inject
	private transient UnitMapper unitMapper;
	
	public InventoryService(){
		
	}
	
	public InventoryPendingList loadInventoryPending(){
		return new InventoryPendingList(inventoryMapper.loadInventoryPending());
	}
	
	public InventoryActiveList forDelivery(long[] itemNumber){
		List<InventoryPending> inventoryPendingList = inventoryMapper.loadInventoryPendingList(itemNumber);
		List<InventoryActive> arrInventoryActive = new ArrayList<InventoryActive>();
		for(InventoryPending inventoryPending: inventoryPendingList){
			arrInventoryActive.add(new InventoryActive(inventoryPending));
		}
		
		return new InventoryActiveList(arrInventoryActive);
		
	}
	
	@Transactional
	public void delivered(InventoryActiveList inventoryActiveList, long[] itemNumber){
		
		List<InventoryActive> arrInventoryActive = inventoryActiveList.getInventoryList();
		
		List<InventoryPending> arrInventoryPending = inventoryMapper.loadInventoryPendingList(itemNumber);
		
		for(int i = 0; i < arrInventoryPending.size(); i++){
			InventoryActive inventoryActive = arrInventoryActive.get(i);
			inventoryActive.setInventory(arrInventoryPending.get(i));
			UnitAndPostUnit unitAndPostUnit = unitMapper.loadUnitAndPostUnit(inventoryActive.getUnitCode());
			String codePostUnit = unitAndPostUnit.getCodePostUnit();
			if(!codePostUnit.isEmpty()){
				inventoryActive.setUnitCode(codePostUnit);
				int quantity = (int) (inventoryActive.getQuantity() * unitAndPostUnit.getConversionFactor());
				inventoryActive.setQuantity(quantity);
				double unitPrice = inventoryActive.getUnitPrice() / unitAndPostUnit.getConversionFactor();
				inventoryActive.setUnitPrice(unitPrice);
			}
		}
		
		inventoryMapper.addPendingHist(arrInventoryPending);
	
		inventoryMapper.saveToInventory(arrInventoryActive);
		
		inventoryMapper.deleteInventoryPending(itemNumber);	
	}
	
	public InventoryActiveList loadInventory(){
		return new InventoryActiveList(inventoryMapper.loadInventoryActive());
	}
	
	public InventoryActiveList loadInventory(String code){
		return new InventoryActiveList(inventoryMapper.loadInventoryActive(code));
	}
	
	@Transactional
	public void consolidateInventory(InventoryActiveList inventoryActiveList){
		
		for(InventoryActive inventoryActive: inventoryActiveList.getInventoryList()){
			if(inventoryActive.getQuantity() == 0){
				inventoryMapper.deleteInventory(inventoryActive.getItemNumber());
			}
			inventoryMapper.updateInventoryActive(inventoryActive);
		}
	}

}
