package com.app.erp.mapper;

import java.sql.Date;
import java.util.List;

import com.app.erp.model.Tran;
import com.app.erp.model.TranOrder;

public interface TranMapper {

	List<Tran> loadTransaction(String startDate, String endDate);
	
	List<TranOrder> loadTransactionOrder(long code);
}
