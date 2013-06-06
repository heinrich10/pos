package com.app.erp.mapper;

import java.util.List;

import com.app.erp.model.MenuItem;
import com.app.erp.model.MenuItemType;



public interface MenuItemMapper {
	
	List<MenuItem> loadMenuItem();
	
	List<MenuItem> loadMenuItem(String[] codeMenuItem);
	
	void updateMenuItem(MenuItem menuItem);
	
	List<MenuItemType> loadMenuItemType();
	
	MenuItemType loadMenuItemType(String code);
	
	void saveMenuItemType(MenuItemType menuItemType);
	
	void updateMenuItemType(MenuItemType menuItemType);
	
	void deleteMenuItemType(String[] code);
	
	
}
