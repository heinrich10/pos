package com.app.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.MenuItemMapper;
import com.app.erp.model.MenuItem;
import com.app.erp.model.MenuItemList;
import com.app.erp.model.MenuItemType;
import com.app.erp.util.ErrorMessageUtil;

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
		return editMenuItemWithValidation(myModel, menuItemList);
		
	}
	
	@RequestMapping(value= "/mi/edit", method=RequestMethod.POST)
	public ModelAndView updateMenuItem(
			@ModelAttribute("menuItemList") @Valid MenuItemList menuItemList,
			BindingResult result
			){
		
		if(result.hasErrors()){
			return editMenuItemWithValidation(new HashMap<String, Object>(), menuItemList);
		} else {
			for(MenuItem mi:menuItemList.getMenuItemList()){
				menuItemMapper.updateMenuItem(mi);
			}
			
			return new ModelAndView("redirect:/maintenance/mi");
		}
		
		
		
	}
	
	private ModelAndView editMenuItemWithValidation(Map<String, Object> myModel, MenuItemList menuItemList){
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("menuItemList", menuItemList);
		myModel.put("menuItemType", arrMenuItemType);
		myModel.put("tabletype", "menuItemEdit");
		
		return new ModelAndView("maintenance", myModel);
	}
	
	@RequestMapping(value = "/mi/type", method=RequestMethod.GET)
	public ModelAndView viewMenuItemType(Map<String, Object> myModel){
		
		return viewMenuItemTypeWithValidation(myModel);
		
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.GET)
	public ModelAndView addMenuItemType(Map<String, Object> myModel,
			MenuItemType menuItemType){
		
		return addMenuItemTypeWithValidation(myModel, menuItemType);
		
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.POST)
	public ModelAndView saveMenuItemType(
			@ModelAttribute("menuItemType") @Valid MenuItemType menuItemType,
			BindingResult result,
			SessionStatus status
			){
		
		if(result.hasErrors()){
			return addMenuItemTypeWithValidation(new HashMap<String, Object>(), menuItemType);
		} else {
			menuItemMapper.saveMenuItemType(menuItemType);
			
			return new ModelAndView("redirect:/maintenance/mi/type");
		}
		
	}
	
	private ModelAndView addMenuItemTypeWithValidation(
			Map<String, Object> myModel, MenuItemType menuItemType){
		
		myModel.put("editType", "miType");
		myModel.put("menuItemType", menuItemType);
		
		return new ModelAndView("edit", myModel);
		
	}
	
	@RequestMapping(value = "/mi/type/delete", method=RequestMethod.POST)
	public ModelAndView deleteMenuItemType(
			@RequestParam("code") String[] code
			){
		
		for(int i=0; i < code.length; i++){
			if(menuItemMapper.allowDeletion(code[i]) > 0){
				Map<String, Object> myModel = new HashMap<String, Object>();
				
				myModel.put("errorMsg", ErrorMessageUtil.DEL_MI_ERROR);
				return viewMenuItemTypeWithValidation(myModel);
				
			}
		}
		
		menuItemMapper.deleteMenuItemType(code);
		
		return new ModelAndView("redirect:/maintenance/mi/type");
	}
	
	private ModelAndView viewMenuItemTypeWithValidation(Map<String, Object> myModel	){
		
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("object", arrMenuItemType);
		myModel.put("tabletype", "mitype");
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
}
