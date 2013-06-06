package com.app.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.IngredientMapper;
import com.app.erp.model.IngredientCode;
import com.app.erp.model.IngredientType;

@Controller
@RequestMapping("/maintenance")
public class IngredientController {
	
	@Inject
	IngredientMapper ingredientMapper;
	
	@RequestMapping("/ingredient")
	public ModelAndView viewIngredientCode(){
		
		List<IngredientCode> arrIngredientCode;
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("ingredient", arrIngredientCode);
		myModel.put("tabletype", "ingredient");
		
				
		return new ModelAndView("maintenance", "model", myModel);
	}
	
	@RequestMapping(value = "/ingredient/add", method=RequestMethod.GET)
	public ModelAndView addIngredient(Map<String, Object> myModel){
		
		List<IngredientType> arrIngredientType = ingredientMapper.loadIngredientType();
		
		myModel.put("editType", "ingredient");
		myModel.put("ingredientType", arrIngredientType);
		myModel.put("ingredientCode", new IngredientCode());
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value = "/ingredient/add", method=RequestMethod.POST)
	public String sumbitIngredient(
			@ModelAttribute("ingredient") IngredientCode ingredientCode
			){
		
		ingredientMapper.saveIngredientCode(ingredientCode);
		
		return "redirect:/maintenance/ingredient";
	}
	@RequestMapping(value="/ingredient/delete", method=RequestMethod.POST)
	public String deleteIngredient(
			@RequestParam("code") String[] code
			){
		
		ingredientMapper.deleteIngredientCode(code);
		
		return "redirect:/maintenance/ingredient";
	}
	
	@RequestMapping(value="/ingredient/type", method=RequestMethod.GET)
	public ModelAndView viewIngredientType(Map<String, Object> myModel){
		
		List<IngredientType> arrIngredientType = ingredientMapper.loadIngredientType();
		
		myModel.put("tabletype", "ingredientType");
		myModel.put("ingredientType", arrIngredientType);
		
		return new ModelAndView("maintenance", myModel);
	}
	
	@RequestMapping(value="/ingredient/type/add", method=RequestMethod.GET)
	public ModelAndView addIngredientType(
			Map<String, Object> myModel,
			IngredientType ingredientType){
		
		myModel.put("editType", "ingredientType");
		myModel.put("ingredientType", ingredientType);
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value="/ingredient/type/add", method=RequestMethod.POST)
	public String submitIngredientType(
			@ModelAttribute("ingredientType") IngredientType ingredientType
			){
		
		ingredientMapper.saveIngredientType(ingredientType);
		
		return "redirect:/maintenance/ingredient/type";
	}
	
	@RequestMapping(value="/ingredient/type/delete", method=RequestMethod.POST)
	public String deleteIngredientType(
			@RequestParam("code") String[] code){
		
		ingredientMapper.deleteIngredientType(code);
		
		return "redirect:/maintenance/ingredient/type";
	}
}
