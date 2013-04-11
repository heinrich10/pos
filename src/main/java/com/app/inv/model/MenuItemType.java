package com.app.inv.model;

public class MenuItemType {
	private String code;
    private String name;
    
    public MenuItemType(String code, String name){
        this.code = code;
        this.name = name;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getName(){
        return name;
    }
}
