package com.app.erp.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501175155322877629L;
	private String codeMenu;
    private String codeIngredient;
    private String name;
    private int quantity;
    private String unit;
    private String unitName;
    
    public Ingredient(){
    	
    }
    
    public Ingredient(String codeMenu, String codeIngredient, String name){
    	this.codeMenu = codeMenu;
    	this.codeIngredient = codeIngredient;
    	this.name = name;
    }
    
    public String getCodeMenu(){
        return codeMenu;
    }
    
    public void setCodeMenu(String codeMenu){
    	this.codeMenu = codeMenu;
    }
    
    public String getCodeIngredient(){
        return codeIngredient;
    }
    
    public void setCodeIngredient(String codeIngredient){
    	this.codeIngredient = codeIngredient;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
    	this.quantity = quantity;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public void setUnit(String unit){
    	this.unit = unit;
    }
    
    public String getUnitName(){
        return unitName;
    }
    
    public void setUnitName(String unitName){
    	this.unitName = unitName;
    }
    
}
