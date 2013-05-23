package com.app.inv.mapper;

import java.sql.Date;
import java.util.List;

import com.app.inv.model.Tran;
import com.app.inv.model.TranOrder;

public interface TranMapper {

	List<Tran> loadTransaction(String startDate, String endDate);
	
	List<TranOrder> loadTransactionOrder(long code);
}
