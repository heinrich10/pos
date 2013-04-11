package com.app.inv.model;

public class Ingredient {
	private String codeMenu;
    private String codeIngredient;
    private String name;
    private int quantity;
    private String unit;
    private String unitName;
    
    public Ingredient(String codeMenu, String codeIngredient, String name,  int quantity, String unit, String unitName){
        this.codeMenu = codeMenu;
        this.codeIngredient = codeIngredient;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.unitName = unitName;
    }
    
    public String getCodeMenu(){
        return codeMenu;
    }
    
    public String getCodeIngredient(){
        return codeIngredient;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getUnitName(){
        return unitName;
    }
}
