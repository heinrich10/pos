package com.app.erp.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class MenuItemType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3623212453959297759L;
	@Size(min=1, max=10)
	private String code;
	@Size(min=1, max=45)
    private String name;
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
    	this.code = code;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
}
