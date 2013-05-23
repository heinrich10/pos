package com.app.inv.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.DiscountMapper;
import com.app.inv.model.Discount;

@Controller
@RequestMapping("/maintenance")
public class DiscountController {
	
	@Inject
	private DiscountMapper discountMapper;
	
	@RequestMapping(value="/discount/", method=RequestMethod.GET)
	public ModelAndView loadDiscounts(Map<String, Object> myModel){
		
		List<Discount> discountList = discountMapper.loadDiscount();
		
		myModel.put("tabletype", "discount");
		myModel.put("discount", discountList);
		
		return new ModelAndView("maintenance", myModel);
	}
	
	@RequestMapping(value="/discount/add", method=RequestMethod.GET)
	public ModelAndView addDiscounts(Discount discount, Map<String, Object> myModel){
		
		myModel.put("editType", "discount");
		myModel.put("discount", discount);
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value="/discount/add", method=RequestMethod.POST)
	public String submitDiscounts(@ModelAttribute("discount") Discount discount){
		
		discountMapper.saveDiscount(discount);
		
		return "redirect:/maintenance/discount";
	}
	
	@RequestMapping(value="/discount/delete", method=RequestMethod.POST)
	public String deleteDiscounts(@RequestParam("codeDiscount") String[] codeDiscount){
		
		discountMapper.deleteDiscount(codeDiscount);
		
		return "redirect:/maintenance/discount/";
	}
}
