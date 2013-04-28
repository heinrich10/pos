package com.app.inv.model;

public class IngredientCode {
	private String code;
    private String brand;
    private String name;
    private String typeCode;
    private String type;
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
    	this.code = code;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
    	this.brand = brand;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public String getTypeCode(){
        return typeCode;
    }
    
    public void setTypeCode(String typeCode){
    	this.typeCode = typeCode;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
    	this.type = type;
    }
    
    public String getFullName(){
    	return brand + " " + name;
    }
}
