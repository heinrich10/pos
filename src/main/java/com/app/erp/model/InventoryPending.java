package com.app.erp.model;

import java.sql.Date;

public class InventoryPending extends Inventory{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7733784514301770910L;
	private Date orderDate;
    
	public Date getOrderDate(){
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate){
		this.orderDate = orderDate;
	}
}
