package com.app.inv.model;

import java.util.Date;

public class Tran {
	private long codeTransaction;
    private boolean indDineIn;
    private String menuItemName;
    private double menuItemPrice;
    private double totalAmount;
    private Date timeStamp;
    private OrderList orderList;
    
    public long getCodeTransaction(){
        return codeTransaction;
    }
    
    public void setCodeTransaction(long codeTransaction){
    	this.codeTransaction = codeTransaction;
    }
    
    public boolean getIndDineIn(){
        return indDineIn;
    }
    
    public void setIndDineIn(boolean indDineIn){
    	this.indDineIn = indDineIn;
    }
    
    public String getMenuItemName(){
        return menuItemName;
    }
    
    public void setMenuItemName(String menuItemName){
    	this.menuItemName = menuItemName;
    }
    
    public double getMenuItemPrice(){
        return menuItemPrice;
    }
    
    public void setMenuItemPrice(double menuItemPrice){
    	this.menuItemPrice = menuItemPrice;
    }
    
    public double getTotalAmount(){
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount){
    	this.totalAmount = totalAmount;
    }
    
    public Date getTimeStamp(){
        return timeStamp;
    }
    
    public void setTimeStamp(Date timeStamp){
    	this.timeStamp = timeStamp;
    }
    
    public OrderList getOrderList(){
    	return orderList;
    }
    
    public void setOrderList(OrderList orderList){
    	this.orderList = orderList;
    }
    
}
