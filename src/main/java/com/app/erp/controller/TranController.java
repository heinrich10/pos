package com.app.erp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.erp.mapper.TranMapper;
import com.app.erp.model.OrderList;
import com.app.erp.model.Tran;

@Controller
@RequestMapping("/accounting/transaction")
public class TranController {
	
	@Inject
	TranMapper tranMapper;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView viewTran(Map<String, Object> myModel){
		/**
		List<Tran> tranList = tranMapper.loadTransaction(Date.valueOf("2013-05-09"));
		
		for(Tran tran:tranList){
			OrderList orderList = new OrderList(tranMapper.loadTransactionOrder(tran.getCodeTransaction()));
			tran.setOrderList(orderList);
		}
		
		myModel.put("tabletype", "transaction");
		myModel.put("tran", tranList);
		
		return new ModelAndView("accounting", myModel);
		**/
		return null;
	}
	
}
