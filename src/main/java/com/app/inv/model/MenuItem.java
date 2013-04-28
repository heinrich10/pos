package com.app.inv.model;

public class MenuItem {
	private String code;
    private String type;
    private String name;
    private String description;
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
