package com.app.inv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
	
	@RequestMapping(value = "/home")
	public String mainPage(){
		return "maintenance";
	}
}
