package com.app.erp.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class IngredientCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2229087466330498258L;
	@Size(min=1, max=10)
	protected String code;
	@Size(min=1, max=45)
	protected String brand;
	@Size(min=1, max=45)
	protected String name;
	protected String typeCode;
	protected String type;
    
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
