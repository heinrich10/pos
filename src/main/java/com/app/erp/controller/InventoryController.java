package com.app.erp.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.IngredientMapper;
import com.app.erp.mapper.InventoryMapper;
import com.app.erp.mapper.UnitMapper;
import com.app.erp.model.IngredientCode;
import com.app.erp.model.Inventory;
import com.app.erp.model.InventoryActive;
import com.app.erp.model.InventoryActiveList;
import com.app.erp.model.InventoryHist;
import com.app.erp.model.InventoryPending;
import com.app.erp.model.Unit;
import com.app.erp.model.UnitAndPostUnit;
import com.app.erp.validator.InventoryValidator;

@Controller
@RequestMapping("/inventory")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_UNCOMMITTED)
public class InventoryController {
	
	@Inject
	private InventoryMapper inventoryMapper;
	@Inject
	private InventoryValidator inventoryValidator;
	@Inject
	private IngredientMapper ingredientMapper;
	@Inject
	private UnitMapper unitMapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		return "inventory";
	}
	
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView getInventory() {

		List<InventoryActive> arrInventoryActive;
		
		arrInventoryActive = inventoryMapper.loadInventoryActive();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventoryActive);
		myModel.put("tabletype", "active");
		
		
		return new ModelAndView("inventory", "model", myModel);

	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView getInventoryPending() {

		List<InventoryPending> arrInventory;

		arrInventory = inventoryMapper.loadInventoryPending();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		myModel.put("tabletype", "pending");

		return new ModelAndView("inventory", "model", myModel);

	}
	
	@RequestMapping(value = "/hist", method = RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView getInventoryHist(){
		List<InventoryHist> arrInventoryHist;

		arrInventoryHist = inventoryMapper.loadInventoryHist();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventoryHist);
		myModel.put("tabletype", "history");

		return new ModelAndView("inventory", myModel);
		
	}
	
	@RequestMapping(value = "/pending/add", method = RequestMethod.GET)
	public ModelAndView addInventoryPending(Map<String, Object> myModel){
		List<IngredientCode> arrIngredientCode;
		List<Unit> arrUnit;
		Inventory inventory = new Inventory();
		
		arrIngredientCode = ingredientMapper.loadIngredientCode();
		arrUnit = unitMapper.loadUnit();
		
		myModel.put("inventory", inventory);
		myModel.put("ingredientCode", arrIngredientCode);
		myModel.put("unit", arrUnit);
		myModel.put("editType", "inventory");
		
		return new ModelAndView("edit", myModel);
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
			@RequestParam("itemNumber") long[] itemNumber
			){
		inventoryMapper.deleteInventoryPending(itemNumber);
		return "redirect:/inventory/pending";
	}
	
	@RequestMapping(value ="/pending/delivered", method = RequestMethod.GET)
	public ModelAndView moveToInventory(
			@RequestParam("itemNumber") long[] itemNumber,
			Map<String, Object> myModel
			){
		
		
		
		List<InventoryPending> arrInventory = inventoryMapper.loadInventoryPendingList(itemNumber);
		
		List<InventoryActive> arrInventoryActive = new ArrayList<InventoryActive>();
		for(int i = 0; i < arrInventory.size(); i++){
			arrInventoryActive.add(new InventoryActive(arrInventory.get(i)));
		}
		
		
		myModel.put("tabletype", "deliver");
		myModel.put("inventory", new InventoryActiveList(arrInventoryActive));
		//myModel.put("inventory", arrInventoryActive);
		
		//ArrayList<InventoryPending> arrInventoryPedning = inventoryMapper.loadInventoryPending(itemNumber);
		
		//inventoryMapper.addPendingHist(arrInventoryPending);
		
		//inventoryMapper.saveToInventory(inventory);
		
		//inventoryMapper.deleteInventoryPending(itemNumber);
		
		return new ModelAndView("inventory", myModel);
	}
	
	@RequestMapping(value ="/pending/delivered", method = RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class)
	public String submitMoveToInventory(
			@ModelAttribute("inventory") InventoryActiveList inventoryActiveList,
			@RequestParam("itemNumber") long[] itemNumber
			){
		
		List<InventoryActive> arrInventoryActive = (ArrayList<InventoryActive>) inventoryActiveList.getInventoryList();
		
		
		List<InventoryPending> arrInventoryPending = inventoryMapper.loadInventoryPendingList(itemNumber);
		
		for(int i = 0; i < arrInventoryPending.size(); i++){
			InventoryActive inventoryActive = arrInventoryActive.get(i);
			inventoryActive.setInventory(arrInventoryPending.get(i));
			UnitAndPostUnit unitAndPostUnit = unitMapper.loadUnitAndPostUnit(inventoryActive.getUnitCode());
			inventoryActive.setUnitCode(unitAndPostUnit.getCodePostUnit());
			int quantity = (int) (inventoryActive.getQuantity() * unitAndPostUnit.getConversionFactor());
			inventoryActive.setQuantity(quantity);
		}
		
		inventoryMapper.addPendingHist(arrInventoryPending);
	
		inventoryMapper.saveToInventory(arrInventoryActive);
		
		inventoryMapper.deleteInventoryPending(itemNumber);		
		
		return "redirect:/inventory/active";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}