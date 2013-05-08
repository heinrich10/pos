package com.app.inv.mapper;

import java.util.List;

import com.app.inv.model.Inventory;
import com.app.inv.model.InventoryActive;
import com.app.inv.model.InventoryHist;
import com.app.inv.model.InventoryPending;

public interface InventoryMapper {
	 
	List<InventoryActive> loadInventoryActive(String codeIngredient);
	    
	List<InventoryActive> loadInventoryActive();
	  
	List<InventoryPending> loadInventoryPending();
	
	List<InventoryPending> loadInventoryPendingList(long[] itemNumber);
	
	List<InventoryHist> loadInventoryHist();
	
	void saveInventoryPending(Inventory inventory);
	    
	void deleteInventoryPending(long[] itemNumber);
	    
	void deleteInventory(long itemNumber);
	    
	void saveToInventory(List<InventoryActive> arrInventoryActive);
	    
	void addPendingHist(List<InventoryPending> arrInventoryPending);
	    
	void updateInventory(long itemNumber, int quantity);
}
