package com.app.inv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.IngredientMapper;
import com.app.inv.model.IngredientCode;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
	
	@Inject
	IngredientMapper ingredientMapper;
	
	@RequestMapping("/home")
	public String mainPage(){
		
		return "maintenance";
		
	}
	
	@RequestMapping("/mi")
	public ModelAndView viewMenuItem(Model model){
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("tabletype", "menuItem");
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
	
	@RequestMapping("/unit")
	public ModelAndView viewUnit(Model model){
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("tabletype", "unit");
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
	
	
	@RequestMapping("/ingredient")
	public ModelAndView viewIngredientCode(){
		
		ArrayList<IngredientCode> arrIngredientCode;
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("ingredient", arrIngredientCode);
		myModel.put("tabletype", "ingredient");
		
				
		return new ModelAndView("maintenance", "model", myModel);
	}
	
	
}
