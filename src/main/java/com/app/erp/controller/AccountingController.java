package com.app.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounting")
public class AccountingController {
	
	@RequestMapping(value = "/")
	public String home(){
		return "accounting";
	}
	
}
