package com.app.inv.mapper;

import java.util.List;

import com.app.inv.model.Unit;
import com.app.inv.model.UnitAndPostUnit;

public interface UnitMapper {
	
	List<Unit> loadUnit();
	
	List<UnitAndPostUnit> loadUnitAndPostUnit();
	
	UnitAndPostUnit loadUnitAndPostUnit(String codeUnit);
	
	void saveUnit(UnitAndPostUnit unitAndPostUnit);
	
	void updateUnit(UnitAndPostUnit unitAndPostUnit);
	
	void deleteUnit(String codeUnit);
}
