package com.app.erp.model;

import java.sql.Date;

public class InventoryHist extends Inventory{
	
	private Date orderDate;
	private java.util.Date deliveryDate;
    
	public Date getOrderDate(){
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate){
		this.orderDate = orderDate;
	}
	
	public java.util.Date getDeliveryDate(){
		return deliveryDate;
	}
	
	public void setDeliveryDate(java.util.Date deliveryDate){
		this.deliveryDate = deliveryDate;
	}
}
