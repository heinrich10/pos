package com.app.inv.model;

import java.sql.Date;

public class InventoryActive extends Inventory {
	
	private Date stockDate;
    private Date roastDate;
    private Date expDate;
    private String comment;
    
    public InventoryActive(){
    	super();
    	
    }
	
    public Date getStockDate(){
    	return stockDate;
        
    }
    
    public void setStockDate(Date stockDate){
    	this.stockDate = stockDate;
    }
    
    public Date getRoastDate(){
        return roastDate;
    }
    
    public void setRoastDate(Date roastDate){
        this.roastDate = roastDate;
    }
    
    public Date getExpDate(){
        return expDate;
    }
    
    public void setExpDate(Date expDate){
        this.expDate = expDate;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
}