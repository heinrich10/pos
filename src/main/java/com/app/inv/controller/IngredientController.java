package com.app.inv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.IngredientMapper;
import com.app.inv.model.IngredientCode;
import com.app.inv.model.IngredientType;

@Controller
@RequestMapping("/maintenance")
public class IngredientController {
	
	@Inject
	IngredientMapper ingredientMapper;
	
	@RequestMapping("/ingredient")
	public ModelAndView viewIngredientCode(){
		
		ArrayList<IngredientCode> arrIngredientCode;
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("ingredient", arrIngredientCode);
		myModel.put("tabletype", "ingredient");
		
				
		return new ModelAndView("maintenance", "model", myModel);
	}
	
	@RequestMapping(value = "/ingredient/add", method=RequestMethod.GET)
	public ModelAndView addIngredient(Map<String, Object> myModel){
		
		ArrayList<IngredientType> arrIngredientType = ingredientMapper.loadIngredientType();
		
		myModel.put("editType", "ingredient");
		myModel.put("ingredientType", arrIngredientType);
		myModel.put("ingredientCode", new IngredientCode());
		
		return new ModelAndView("edit", myModel);
	}
	
}
