package com.app.erp.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class InventoryActive extends Inventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1057367550230251747L;
	
	private Date stockDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date roastDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expDate;
    private String comment;
    
    public InventoryActive(){
    	
    }
    
    public InventoryActive(Inventory inventory){
    	super(inventory);
    	
    }
    
    public java.sql.Date getStockDate(){
    	if(stockDate == null){
    		return null;
    	} else {
    	return new java.sql.Date(stockDate.getTime());
    	}
    }
    
    public void setStockDate(Date stockDate){
    	this.stockDate = stockDate;
    }
    
    public java.sql.Date getRoastDate(){
    	if(roastDate == null){
    		return null;
    	} else {
    	return new java.sql.Date(roastDate.getTime());
    	}
    }
    
    public void setRoastDate(Date roastDate){
        this.roastDate = roastDate;
    }
    
    public java.sql.Date getExpDate(){
    	if(expDate == null){
    		return null;
    	} else {
    	return new java.sql.Date(expDate.getTime());
    	}
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
