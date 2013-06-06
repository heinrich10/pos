package com.app.erp.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.UnitMapper;
import com.app.erp.model.Unit;
import com.app.erp.model.UnitAndPostUnit;

@Controller
@RequestMapping("/maintenance")
public class UnitController {
	
	@Inject
	UnitMapper unitMapper;
	
	@RequestMapping("/unit")
	public ModelAndView viewUnit(Map<String, Object> myModel){
		
		List<UnitAndPostUnit> arrUnitAndPostUnit = unitMapper.loadUnitAndPostUnit();
		
		myModel.put("tabletype", "unit");
		myModel.put("object", arrUnitAndPostUnit);
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
	
	@RequestMapping(value = "/unit/add", method = RequestMethod.GET)
	public ModelAndView addUnit(Map<String, Object> myModel){
		
		UnitAndPostUnit unitAndPostUnit = new UnitAndPostUnit();
		
		List<Unit> arrUnit = unitMapper.loadUnit();
		
		myModel.put("unit", arrUnit);
		myModel.put("unitAndPostUnit", unitAndPostUnit);
		myModel.put("editType", "unit");
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value = "/unit/add", method = RequestMethod.POST)
	public String saveUnit(
			@ModelAttribute("unitAndPostUnit") UnitAndPostUnit unitAndPostUnit,
			BindingResult result,
			SessionStatus status){
			
			unitMapper.saveUnit(unitAndPostUnit);
			
			return "redirect:/maintenance/unit";
		
	}
	
	@RequestMapping(value = "/unit/edit", method = RequestMethod.GET)
	public ModelAndView editUnit(
			@RequestParam("codeUnit") String codeUnit,
			Map<String, Object> myModel){
		
		UnitAndPostUnit unitAndPostUnit = unitMapper.loadUnitAndPostUnit(codeUnit);
		List<Unit> arrUnit = unitMapper.loadUnit();
		
		myModel.put("unit", arrUnit);
		myModel.put("unitAndPostUnit", unitAndPostUnit);
		myModel.put("editType", "unit");
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value = "/unit/edit", method = RequestMethod.POST)
	public String updateUnit(
			@ModelAttribute("unitAndPostUnit") UnitAndPostUnit unitAndPostUnit,
			BindingResult result,
			SessionStatus status){
			
			unitMapper.updateUnit(unitAndPostUnit);
			
			return "redirect:/maintenance/unit";
	}
	@RequestMapping(value = "/unit/delete", method = RequestMethod.POST)
	public String deleteUnit(@RequestParam("codeUnit") String codeUnit){
		
		unitMapper.deleteUnit(codeUnit);
		
		return "redirect:/maintenance/unit";
	}
}
