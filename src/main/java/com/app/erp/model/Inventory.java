package com.app.erp.model;

import java.io.Serializable;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1364156537404136372L;
	protected long itemNumber;
	protected String name;
	protected String codeIngredient;
	protected int quantity;
	protected double unitPrice;
	protected String unit;
	protected String unitCode;
	protected double totalPrice;
    
	public Inventory(){
		
	}
	
	public Inventory(Inventory inventory){
		setInventory(inventory);
	}
	
	public void setInventory(Inventory inventory){
		this.itemNumber = inventory.itemNumber;
		this.name = inventory.name;
		this.codeIngredient = inventory.codeIngredient;
		this.quantity = inventory.quantity;
		this.unitPrice = inventory.unitPrice;
		this.unit = inventory.unit;
		this.unitCode = inventory.unitCode;
		this.totalPrice = inventory.totalPrice;
	}
	
    public long getItemNumber(){
    	return itemNumber;
    }
    
    public void setItemNumber(long itemNumber){
    	this.itemNumber = itemNumber;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public String getCodeIngredient(){
        return codeIngredient;
    }
    
    public void setCodeIngredient(String codeIngredient){
    	this.codeIngredient = codeIngredient;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
    	this.quantity = quantity;
    }
    
    public double getUnitPrice(){
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public void setUnit(String unit){
    	this.unit = unit;
    }
    
    public String getUnitCode(){
        return unitCode;
    }
    
    public void setUnitCode(String unitCode){
        this.unitCode = unitCode;
    }
    
    public double getTotalPrice(){
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice){
    	this.totalPrice = totalPrice;
    }
}
