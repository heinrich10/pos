package com.app.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system/parameters")
public class ParametersController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView viewParameters(){
		
		
		return new ModelAndView("parameters");
	}
}
