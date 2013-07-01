package com.app.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.IngredientMapper;
import com.app.erp.model.IngredientCode;
import com.app.erp.model.IngredientType;
import com.app.erp.util.ErrorMessageUtil;

@Controller
@RequestMapping("/maintenance")
public class IngredientController {
	
	@Inject
	IngredientMapper ingredientMapper;
	
	@RequestMapping("/ingredient")
	public ModelAndView viewIngredientCode(Map<String, Object> myModel){
		
		return viewIngredientCodeWithValidation(myModel);
	}
	
	@RequestMapping(value = "/ingredient/add", method=RequestMethod.GET)
	public ModelAndView addIngredient(Map<String, Object> myModel, IngredientCode ingredientCode){
		
		return addIngredientWithValidation(myModel, ingredientCode);
		
	}
	
	@RequestMapping(value = "/ingredient/add", method=RequestMethod.POST)
	public ModelAndView sumbitIngredient(
			@ModelAttribute("ingredientCode") @Valid IngredientCode ingredientCode,
			BindingResult result
			){
		
		if(result.hasErrors()){
			
			return addIngredientWithValidation(new HashMap<String, Object>(), ingredientCode);
			
		} else {
			
			ingredientMapper.saveIngredientCode(ingredientCode);
			return new ModelAndView("redirect:/maintenance/ingredient");
		}
		
		
	}
	
	private ModelAndView addIngredientWithValidation(Map<String, Object> myModel,
			IngredientCode ingredientCode){
		
		List<IngredientType> arrIngredientType = ingredientMapper.loadIngredientType();
		
		myModel.put("editType", "ingredient");
		myModel.put("ingredientType", arrIngredientType);
		myModel.put("ingredientCode", ingredientCode);
		
		return new ModelAndView("edit", myModel);
		
	}
	
	@RequestMapping(value="/ingredient/delete", method=RequestMethod.POST)
	public ModelAndView deleteIngredient(
			@RequestParam("code") String[] code
			){
		
		for(int i = 0; i < code.length; i++){
			if(ingredientMapper.allowDeletionOfIngredient(code[i]) > 0){
				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("errorMsg", ErrorMessageUtil.DEL_ING_ERROR);
				return viewIngredientCodeWithValidation(myModel);
			}
		}
		ingredientMapper.deleteIngredientCode(code);
		
		return new ModelAndView("redirect:/maintenance/ingredient");
	}
	
	private ModelAndView viewIngredientCodeWithValidation(Map<String, Object> myModel){
		
		List<IngredientCode> arrIngredientCode;
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		
		myModel.put("ingredient", arrIngredientCode);
		myModel.put("tabletype", "ingredient");
		
				
		return new ModelAndView("maintenance", "model", myModel);
	}
	
	@RequestMapping(value="/ingredient/type", method=RequestMethod.GET)
	public ModelAndView viewIngredientType(Map<String, Object> myModel){
		
		return viewIngredientTypeWithValidation(myModel);
		
	}
	
	@RequestMapping(value="/ingredient/type/add", method=RequestMethod.GET)
	public ModelAndView addIngredientType(
			Map<String, Object> myModel,
			IngredientType ingredientType){
		
		return addIngredientTypeWithValidation(myModel, ingredientType);
		
	}
	
	@RequestMapping(value="/ingredient/type/add", method=RequestMethod.POST)
	public ModelAndView submitIngredientType(
			@ModelAttribute("ingredientType") @Valid IngredientType ingredientType,
			BindingResult result
			){
		
		if(result.hasErrors()){
			return addIngredientTypeWithValidation(new HashMap<String, Object>(), ingredientType);
		} else {
			ingredientMapper.saveIngredientType(ingredientType);
			return new ModelAndView("redirect:/maintenance/ingredient/type");
		}
		
		
	}
	
	private ModelAndView addIngredientTypeWithValidation(
			Map<String, Object> myModel,
			IngredientType ingredientType){
		
		myModel.put("editType", "ingredientType");
		myModel.put("ingredientType", ingredientType);
		
		return new ModelAndView("edit", myModel);
		
	}
	
	@RequestMapping(value="/ingredient/type/delete", method=RequestMethod.POST)
	public ModelAndView deleteIngredientType(
			@RequestParam("code") String[] code){
		
		for(int i = 0; i < code.length; i++){
			if(ingredientMapper.allowDeletionOfIngredientType(code[i]) > 0){
				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("errorMsg", ErrorMessageUtil.DEL_ING_TYPE_ERROR);
				
				return viewIngredientTypeWithValidation(myModel);
				
			}
		}
		
		ingredientMapper.deleteIngredientType(code);
		return new ModelAndView("redirect:/maintenance/ingredient/type");
	}
	
	private ModelAndView viewIngredientTypeWithValidation(
			Map<String, Object> myModel){
		
		List<IngredientType> arrIngredientType = ingredientMapper.loadIngredientType();
		
		myModel.put("tabletype", "ingredientType");
		myModel.put("ingredientType", arrIngredientType);
		
		return new ModelAndView("maintenance", myModel);
	}
}
