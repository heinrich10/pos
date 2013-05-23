package com.app.inv.model;

import java.io.Serializable;

public class TranOrder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7133324503848759839L;
	private String menuItemName;
	private double menuItemPrice;
	
	public String getMenuItemName() {
		return menuItemName;
	}
	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}
	public double getMenuItemPrice() {
		return menuItemPrice;
	}
	public void setMenuItemPrice(double menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}
	
}
