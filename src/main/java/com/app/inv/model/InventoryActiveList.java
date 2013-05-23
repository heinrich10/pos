package com.app.inv.model;

import java.io.Serializable;
import java.util.List;

public class InventoryActiveList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1402950202025725184L;
	private List<InventoryActive> inventoryList;
	
	public InventoryActiveList(){
		
	}
	
	public InventoryActiveList(List<InventoryActive> inventoryList){
		this.inventoryList = inventoryList;
	}
	
	public List<InventoryActive> getInventoryList(){
		return inventoryList;
	}
	
	public void setInventoryList(List<InventoryActive> inventoryList){
		this.inventoryList = inventoryList;
	}
}
