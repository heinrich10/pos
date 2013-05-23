package com.app.inv.mapper;

import java.util.List;

import com.app.inv.model.Discount;

public interface DiscountMapper {
	
	List<Discount> loadDiscount();
	
	void saveDiscount(Discount discount);
	
	void deleteDiscount(String[] codeDiscount);
	
}
