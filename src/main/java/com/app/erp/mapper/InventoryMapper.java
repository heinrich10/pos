package com.app.erp.mapper;

import java.util.List;

import com.app.erp.model.Inventory;
import com.app.erp.model.InventoryActive;
import com.app.erp.model.InventoryHist;
import com.app.erp.model.InventoryPending;

public interface InventoryMapper {
	 
	List<InventoryActive> loadInventoryActive(String codeIngredient);
	    
	List<InventoryActive> loadInventoryActive();
	
	void updateInventoryActive(InventoryActive inventoryActive);
	  
	List<InventoryPending> loadInventoryPending();
	
	List<InventoryPending> loadInventoryPendingList(long[] itemNumber);
	
	List<InventoryHist> loadInventoryHist();
	
	void saveInventoryPending(Inventory inventory);
	    
	void deleteInventoryPending(long[] itemNumber);
	    
	void deleteInventory(long itemNumber);
	    
	void saveToInventory(List<InventoryActive> arrInventoryActive);
	    
	void addPendingHist(List<InventoryPending> arrInventoryPending);
	    
	//void updateInventory(long itemNumber, int quantity);
}
