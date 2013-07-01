package com.app.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.DiscountMapper;
import com.app.erp.model.Discount;

@Controller
@RequestMapping("/maintenance")
public class DiscountController {
	
	@Inject
	private DiscountMapper discountMapper;
	
	@RequestMapping(value="/discount", method=RequestMethod.GET)
	public ModelAndView loadDiscounts(Map<String, Object> myModel){
		
		List<Discount> discountList = discountMapper.loadDiscount();
		
		myModel.put("tabletype", "discount");
		myModel.put("discount", discountList);
		
		return new ModelAndView("maintenance", myModel);
	}
	
	@RequestMapping(value="/discount/add", method=RequestMethod.GET)
	public ModelAndView addDiscounts(Discount discount, Map<String, Object> myModel){
		
		return addDiscountWithValidation(myModel, discount);
	}
	
	@RequestMapping(value="/discount/add", method=RequestMethod.POST)
	public ModelAndView submitDiscounts(
			@ModelAttribute("discount") @Valid Discount discount,
			BindingResult result){
		
		if(result.hasErrors()){
			
			return addDiscountWithValidation(new HashMap<String, Object>(), discount);
			
		} else {
	
			discountMapper.saveDiscount(discount);
			return new ModelAndView("redirect:/maintenance/discount");
		}
		
		
	}
	
	private ModelAndView addDiscountWithValidation(Map<String, Object> myModel, Discount discount){
		
		myModel.put("editType", "discount");
		myModel.put("discount", discount);
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value="/discount/delete", method=RequestMethod.POST)
	public String deleteDiscounts(@RequestParam("codeDiscount") String[] codeDiscount){
		
		discountMapper.deleteDiscount(codeDiscount);
		
		return "redirect:/maintenance/discount";
	}
}
