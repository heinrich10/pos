package com.app.erp.model;

import java.io.Serializable;
import java.util.Date;

public class Tran implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7283930188632012213L;
	private long codeTransaction;
    private boolean indDineIn;
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
