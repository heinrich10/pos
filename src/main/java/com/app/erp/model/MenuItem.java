package com.app.erp.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class MenuItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7976731707644029073L;
	private String code;
    private String type;
    @Size(min=1, max=25)
    private String name;
    @Size(min=1, max=100)
    private String description;
    @Min(0)
    private double price;
    private String typeCode;
    private double recipePrice;

    public void setCode(String code){
    	this.code = code;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setType(String type){
    	this.type = type;
    }
    
    public String getType(){
        return type;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setDescription(String description){
    	this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setPrice(double price){
    	this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setTypeCode(String typeCode){
    	this.typeCode = typeCode;
    }
    
    public String getTypeCode(){
        return typeCode;
    }
    
    public void setRecipePrice(double recipePrice){
        this.recipePrice = recipePrice;
    }
    
    public double getRecipePrice(){
        return recipePrice;
    }
}
