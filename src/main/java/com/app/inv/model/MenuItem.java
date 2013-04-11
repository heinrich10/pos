package com.app.inv.model;

public class MenuItem {
	private String code;
    private String type;
    private String name;
    private String description;
    private double price;
    private String typeCode;
    private double recipePrice;

    public MenuItem(String code, String type, String name, String description, double price, String typeCode){
        this.code = code;
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeCode = typeCode;
                
    }
    
    public String getCode(){
        return code;
    }
     
    public String getType(){
        return type;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public double getPrice(){
        return price;
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
