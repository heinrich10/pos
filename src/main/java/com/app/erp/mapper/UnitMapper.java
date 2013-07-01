package com.app.erp.mapper;

import java.util.List;

import com.app.erp.model.Unit;
import com.app.erp.model.UnitAndPostUnit;

public interface UnitMapper {
	
	List<Unit> loadUnit();
	
	List<UnitAndPostUnit> loadUnitAndPostUnit();
	
	UnitAndPostUnit loadUnitAndPostUnit(String codeUnit);
	
	void saveUnit(UnitAndPostUnit unitAndPostUnit);
	
	void updateUnit(UnitAndPostUnit unitAndPostUnit);
	
	int allowDeletion(String codeUnit);
	
	void deleteUnit(String[] codeUnit);
		
}
