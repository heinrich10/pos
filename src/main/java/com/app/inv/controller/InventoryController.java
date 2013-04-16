package com.app.inv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.IngredientMapper;
import com.app.inv.mapper.InventoryMapper;
import com.app.inv.mapper.UnitMapper;
import com.app.inv.model.IngredientCode;
import com.app.inv.model.Inventory;
import com.app.inv.model.InventoryActive;
import com.app.inv.model.InventoryPending;
import com.app.inv.model.Unit;
import com.app.inv.validator.InventoryValidator;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Inject
	private InventoryMapper inventoryMapper;
	@Inject
	private InventoryValidator inventoryValidator;
	@Inject
	private IngredientMapper ingredientMapper;
	@Inject
	private UnitMapper unitMapper;

	
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public ModelAndView getInventory() {

		ArrayList<InventoryActive> arrInventoryActive;
		
		arrInventoryActive = inventoryMapper.loadInventoryActive();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventoryActive);
		myModel.put("tabletype", "active");
		
		
		return new ModelAndView("inventory", "model", myModel);

	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public ModelAndView getInventoryPending() {

		ArrayList<InventoryPending> arrInventory;

		arrInventory = inventoryMapper.loadInventoryPending();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		myModel.put("tabletype", "pending");

		return new ModelAndView("inventory", "model", myModel);

	}
	
	@RequestMapping(value = "/pending/add", method = RequestMethod.GET)
	public ModelAndView addInventoryPending(Map<String, Object> myModel){
		ArrayList<IngredientCode> arrIngredientCode;
		ArrayList<Unit> arrUnit;
		Inventory inventory = new Inventory();
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		arrUnit = unitMapper.loadUnit();
		
		myModel.put("inventory", inventory);
		myModel.put("ingredientCode", arrIngredientCode);
		myModel.put("unit", arrUnit);
		
		return new ModelAndView("inventoryPendingAdd", myModel);
	}
	
	@RequestMapping(value = "/pending/add", method = RequestMethod.POST)
	public String submitInventoryPending(
			@ModelAttribute("inventory") Inventory inventory,
			BindingResult result,
			SessionStatus status){
			
		inventoryMapper.saveInventoryPending(inventory);
		
		return "redirect:/inventory/pending";
	}
	
	@RequestMapping(value = "/pending/delete", method = RequestMethod.POST)
	public String deleteInventoryPending(
			@RequestParam("itemNumber") long itemNumber
			){
		inventoryMapper.deleteInventoryPending(itemNumber);
		return "redirect:/inventory/pending";
	}
}
