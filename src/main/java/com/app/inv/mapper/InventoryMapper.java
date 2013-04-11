package com.app.inv.mapper;

import java.util.ArrayList;

import com.app.inv.model.Inventory;

public interface InventoryMapper {
	 
	ArrayList<Inventory> loadInventory(String codeIngredient);
	    
	ArrayList<Inventory> loadInventory();
	  
	ArrayList<Inventory> loadInventoryPending();
	    
	void saveInventoryPending(Inventory inventory);
	    
	void deleteInventoryPending(long itemNumber);
	    
	void deleteInventory(long itemNumber);
	    
	void saveToInventory(Inventory inventory);
	    
	void addPendingHist(Inventory inventory);
	    
	void updateInventory(long itemNumber, int quantity);
}
