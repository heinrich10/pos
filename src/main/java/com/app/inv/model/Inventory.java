package com.app.inv.model;

import java.sql.Date;

public class Inventory {
	private long itemNumber;
    private String name;
    private String codeIngredient;
    private int quantity;
    private double unitPrice;
    private String unit;
    private String unitCode;
    private double totalPrice;
    private Date date;
    private Date roastDate;
    private Date expDate;
    private String comment;
    
    public Inventory(long itemNumber, String name, String codeIngredient, int quantity, double unitPrice, String unit, String unitCode, double totalPrice, Date date){
        this.itemNumber = itemNumber;
        this.name = name;
        this.codeIngredient = codeIngredient;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.unitCode = unitCode;
        this.totalPrice = totalPrice;
        this.date = date;
     }
    
    public long getItemNumber(){
        
    	return itemNumber;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCodeIngredient(){
        return codeIngredient;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getUnitPrice(){
        return unitPrice;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getUnitCode(){
        return unitCode;
    }
    
    public Double getTotalPrice(){
        return totalPrice;
    }
    
    public Date getDate(){
        return date;
    }
    
    public Date getRoastDate(){
        return roastDate;
    }
    
    public Date getExpDate(){
        return expDate;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setUnitCode(String unitCode){
        this.unitCode = unitCode;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    
    public void setRoastDate(Date roastDate){
        this.roastDate = roastDate;
    }
    
    public void setExpDate(Date expDate){
        this.expDate = expDate;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
}
