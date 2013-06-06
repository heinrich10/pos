package com.app.erp.model;

import java.io.Serializable;
import java.util.List;

public class InventoryPendingList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -40642806772736466L;
	
	private List<InventoryPending> inventoryPendingList;
	
	public InventoryPendingList(){
		
	}
	
	public InventoryPendingList(List<InventoryPending> inventoryPendingList){
		this.inventoryPendingList = inventoryPendingList;
	}

	public List<InventoryPending> getInventoryPendingList() {
		return inventoryPendingList;
	}

	public void setInventoryPendingList(List<InventoryPending> inventoryPendingList) {
		this.inventoryPendingList = inventoryPendingList;
	}
	
}
