package com.app.inv.model;

import java.util.List;

public class InventoryActiveList {
	
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
	
	public InventoryActive inventoryList(int index){
		return inventoryList.get(index);
	}
	
}
