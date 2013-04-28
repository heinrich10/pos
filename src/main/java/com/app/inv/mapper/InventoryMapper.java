package com.app.inv.mapper;

import java.util.ArrayList;

import com.app.inv.model.Inventory;
import com.app.inv.model.InventoryActive;
import com.app.inv.model.InventoryHist;
import com.app.inv.model.InventoryPending;

public interface InventoryMapper {
	 
	ArrayList<InventoryActive> loadInventoryActive(String codeIngredient);
	    
	ArrayList<InventoryActive> loadInventoryActive();
	  
	ArrayList<InventoryPending> loadInventoryPending();
	
	ArrayList<InventoryPending> loadInventoryPendingList(long[] itemNumber);
	
	ArrayList<InventoryHist> loadInventoryHist();
	
	void saveInventoryPending(Inventory inventory);
	    
	void deleteInventoryPending(long[] itemNumber);
	    
	void deleteInventory(long itemNumber);
	    
	void saveToInventory(ArrayList<InventoryActive> arrInventoryActive);
	    
	void addPendingHist(ArrayList<InventoryPending> arrInventoryPending);
	    
	void updateInventory(long itemNumber, int quantity);
}
