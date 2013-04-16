package com.app.inv.model;

import java.sql.Date;

public class InventoryPending extends Inventory{
	
	private Date orderDate;
    
	public Date getOrderDate(){
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate){
		this.orderDate = orderDate;
	}
}
