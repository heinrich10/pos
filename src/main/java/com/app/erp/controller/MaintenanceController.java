package com.app.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
	
	@RequestMapping(value = "/")
	public String mainPage(){
		return "maintenance";
	}
}
