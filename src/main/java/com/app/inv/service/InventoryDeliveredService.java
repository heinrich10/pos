package com.app.inv.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.app.inv.mapper.InventoryMapper;
import com.app.inv.mapper.UnitMapper;
import com.app.inv.model.InventoryActive;
import com.app.inv.model.InventoryActiveList;
import com.app.inv.model.InventoryPending;
import com.app.inv.model.InventoryPendingList;
import com.app.inv.model.UnitAndPostUnit;

public class InventoryDeliveredService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 965620516500933416L;
	
	@Inject
	private transient InventoryMapper inventoryMapper;
	@Inject
	private transient UnitMapper unitMapper;
	
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
		
		List<InventoryActive> arrInventoryActive = (ArrayList<InventoryActive>) inventoryActiveList.getInventoryList();
		
		List<InventoryPending> arrInventoryPending = inventoryMapper.loadInventoryPendingList(itemNumber);
		
		for(int i = 0; i < arrInventoryPending.size(); i++){
			InventoryActive inventoryActive = arrInventoryActive.get(i);
			inventoryActive.setInventory(arrInventoryPending.get(i));
			UnitAndPostUnit unitAndPostUnit = unitMapper.loadUnitAndPostUnit(inventoryActive.getUnitCode());
			inventoryActive.setUnitCode(unitAndPostUnit.getCodePostUnit());
			int quantity = (int) (inventoryActive.getQuantity() * unitAndPostUnit.getConversionFactor());
			inventoryActive.setQuantity(quantity);
		}
		
		inventoryMapper.addPendingHist(arrInventoryPending);
	
		inventoryMapper.saveToInventory(arrInventoryActive);
		
		inventoryMapper.deleteInventoryPending(itemNumber);	
	}
}
