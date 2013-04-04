package com.app.inv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

	private InventoryMapper inventoryMapper = null;

	@Autowired
	public void setInventoryMapper(InventoryMapper inventoryMapper) {
		this.inventoryMapper = inventoryMapper;
	}

	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public ModelAndView getInventory(Model model) {

		ArrayList<Inventory> arrInventory = null;

		arrInventory = inventoryMapper.loadInventory();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		// model.addAttribute(arrInventory);

		return new ModelAndView("inventory", "model", myModel);

	}

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Inventory> getInventoryPending(Locale locale, Model model) {

		ArrayList<Inventory> arrInventory = null;

		arrInventory = inventoryMapper.loadInventoryPending();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("inventory", arrInventory);
		// model.addAttribute(arrInventory);
		return arrInventory;

	}
}
