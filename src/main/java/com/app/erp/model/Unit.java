package com.app.erp.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class Unit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5718485499627142738L;
	
	@Size(min=1, max=10)
	protected String codeUnit;
	@Size(min=1, max=45)
	protected String name;
    
    /*
    public Unit(String codeUnit, String name){
        this.codeUnit = codeUnit;
        this.name = name;
    }*/
    
    public String getCodeUnit(){
        return codeUnit;
    }
    
    public void setCodeUnit(String codeUnit){
    	this.codeUnit = codeUnit;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
}
