package com.app.inv.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.MenuItemMapper;
import com.app.inv.model.MenuItem;
import com.app.inv.model.MenuItemList;
import com.app.inv.model.MenuItemType;

@Controller
@RequestMapping("/maintenance")
public class MenuItemController {
	
	@Inject
	private MenuItemMapper menuItemMapper;
	
	@RequestMapping(value = "/mi", method = RequestMethod.GET)
	public ModelAndView viewMenuItem(Map<String, Object> myModel){
		
		MenuItemList menuItemList = new MenuItemList(menuItemMapper.loadMenuItem());
		
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("tabletype", "menuItem");
		myModel.put("menuItem", menuItemList);
		myModel.put("mitype", arrMenuItemType);
		
		return new ModelAndView("maintenance", myModel);
		
	}
	
	@RequestMapping(value = "/mi/edit", method=RequestMethod.GET)
	public ModelAndView editMenuItem(
			@RequestParam("code") String[] code,
			Map<String, Object> myModel,
			MenuItemList menuItemList
			){
		menuItemList.setMenuItemList(menuItemMapper.loadMenuItem(code));
		List<MenuItemType> arrMenuItem = menuItemMapper.loadMenuItemType();
		
		myModel.put("menuItem", menuItemList);
		myModel.put("menuItemType", arrMenuItem);
		myModel.put("tabletype", "menuItemEdit");
		
		return new ModelAndView("maintenance", myModel);
		
	}
	
	@RequestMapping(value= "/mi/edit", method=RequestMethod.POST)
	public String updateMenuItem(
			@ModelAttribute("menuItemList") MenuItemList menuItemList
			){
		
		for(MenuItem mi:menuItemList.getMenuItemList()){
			menuItemMapper.updateMenuItem(mi);
		}
		
		return "redirect:/maintenance/mi";
		
	}
	
	@RequestMapping(value = "/mi/type", method=RequestMethod.GET)
	public ModelAndView viewMenuItemType(Map<String, Object> myModel){
		
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("object", arrMenuItemType);
		myModel.put("tabletype", "mitype");
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.GET)
	public ModelAndView addMenuItemType(Map<String, Object> myModel){
		
		myModel.put("editType", "miType");
		myModel.put("menuItemType", new MenuItemType());
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.POST)
	public String saveMenuItemType(
			@ModelAttribute("menuItemType") MenuItemType menuItemType
			){
		
		menuItemMapper.saveMenuItemType(menuItemType);
		
		return "redirect:/maintenance/mi/type";
	}
	
	@RequestMapping(value = "/mi/type/delete", method=RequestMethod.POST)
	public String deleteMenuItemType(
			@RequestParam("code") String[] code
			){
		
		menuItemMapper.deleteMenuItemType(code);
		
		return "redirect:/maintenance/mi/type";
	}
}
