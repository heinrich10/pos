package com.app.inv.mapper;

import java.util.ArrayList;

import com.app.inv.model.MenuItem;
import com.app.inv.model.MenuItemType;



public interface MenuItemMapper {
	
	ArrayList<MenuItem> loadMenuItem();
	
	MenuItem loadMenuItem(String codeMenuItem);
	
	void updateMenuItem(MenuItem menuItem);
	
	ArrayList<MenuItemType> loadMenuItemType();
	
	MenuItemType loadMenuItemType(String code);
	
	void saveMenuItemType(MenuItemType menuItemType);
	
	void updateMenuItemType(MenuItemType menuItemType);
	
	void deleteMenuItemType(String code);
	
	
}
