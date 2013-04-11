package com.app.inv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.InventoryMapper;
import com.app.inv.model.Inventory;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Inject
	private InventoryMapper inventoryMapper;

	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public ModelAndView getInventory() {

		ArrayList<Inventory> arrInventory;

		arrInventory = inventoryMapper.loadInventory();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		myModel.put("tabletype", "active");

		return new ModelAndView("inventory", "model", myModel);

	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public ModelAndView getInventoryPending() {

		ArrayList<Inventory> arrInventory;

		arrInventory = inventoryMapper.loadInventoryPending();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		myModel.put("tabletype", "pending");

		return new ModelAndView("inventory", "model", myModel);

	}
	
	@RequestMapping(value = "/pending/add", method = RequestMethod.GET)
	public String addInventoryPending(){
		return "inventoryPendingAdd";
	}
}
