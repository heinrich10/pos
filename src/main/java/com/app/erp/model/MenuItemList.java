package com.app.erp.model;

import java.io.Serializable;
import java.util.List;

public class MenuItemList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3432964268685210189L;
	private List<MenuItem> menuItemList;
	
	public MenuItemList(){
		
	}
	
	public MenuItemList(List<MenuItem> menuItemList){
		this.menuItemList = menuItemList;
	}
	
	public List<MenuItem> getMenuItemList(){
		return menuItemList;
	}
	
	public void setMenuItemList(List<MenuItem> menuItemList){
		this.menuItemList = menuItemList;
	}
	
}
