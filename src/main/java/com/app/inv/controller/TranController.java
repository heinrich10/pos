package com.app.inv.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.TranMapper;

@Controller
@RequestMapping("/accounting/transaction")
public class TranController {
	
	@Inject
	TranMapper tranMapper;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView viewTran(Map<String, Object> myModel){
		
		
		return new ModelAndView();
	}
	
}
