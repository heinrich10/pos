package com.app.inv.mapper;

import java.util.ArrayList;

import com.app.inv.model.Inventory;

public interface InventoryMapper {
	 
	ArrayList<Inventory> loadInventory();
	    
	ArrayList<Inventory> loadInventoryPending();
}
