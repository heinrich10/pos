package com.app.inv.model;

import java.io.Serializable;
import java.util.List;

public class OrderList implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 4244742121633006674L;
	private List<TranOrder> tranOrderList;
    
    public OrderList(){
    	
    }
	
	public OrderList(List<TranOrder> tranOrderList){
        this.tranOrderList = tranOrderList;
    }
   
    public List<TranOrder> getTranOrderList(){
        return tranOrderList;
    }
    
    public void setTranOrderList(List<TranOrder> tranOrderList){
    	this.tranOrderList = tranOrderList;
    }
}
