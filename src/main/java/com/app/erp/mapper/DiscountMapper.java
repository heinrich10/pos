package com.app.erp.mapper;

import java.util.List;

import com.app.erp.model.Discount;

public interface DiscountMapper {
	
	List<Discount> loadDiscount();
	
	void saveDiscount(Discount discount);
	
	void deleteDiscount(String[] codeDiscount);
	
}
