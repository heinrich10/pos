package com.app.inv.model;

public class IngredientCode {
	private String code;
    private String brand;
    private String name;
    private String typeCode;
    private String type;
    
    public IngredientCode(String code, String brand, String name, String type_code, String type){
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.typeCode = type_code;
        this.type = type;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getName(){
        return name;
    }
    
    public String getTypeCode(){
        return typeCode;
    }
    
    public String getType(){
        return type;
    }
    
    public String getFullName(){
    	return brand + " " + name;
    }
}
