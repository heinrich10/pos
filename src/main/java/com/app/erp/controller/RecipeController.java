package com.app.erp.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.MenuItemMapper;
import com.app.erp.model.MenuItemList;
import com.app.erp.model.Recipe;

@Controller
@RequestMapping("/maintenance/mi")
public class RecipeController {
	
	@Inject
	MenuItemMapper menuItemMapper;
	
	@RequestMapping(value = "/recipe", method=RequestMethod.GET)
	public ModelAndView menuItemRecipe(
			Map<String, Object> myMap,
			MenuItemList menuItemList
			){
		
		menuItemList.setMenuItemList(menuItemMapper.loadMenuItem());
		
		myMap.put("tabletype", "editRecipe");
		myMap.put("menuItem", menuItemList);
		
		return new ModelAndView("maintenance", myMap);
	}
	
	@RequestMapping(value="/recipe/edit", method=RequestMethod.GET)
	public ModelAndView editRecipe(
			@RequestParam("code") String code,
			Map<String, Object> myMap,
			Recipe recipe
			){
		
		
		
		return new ModelAndView("recipe", myMap);
	}
}
