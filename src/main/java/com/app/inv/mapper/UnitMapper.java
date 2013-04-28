package com.app.inv.mapper;

import java.util.ArrayList;
import com.app.inv.model.Unit;
import com.app.inv.model.UnitAndPostUnit;

public interface UnitMapper {
	ArrayList<Unit> loadUnit();
	
	ArrayList<UnitAndPostUnit> loadUnitAndPostUnit();
	
	UnitAndPostUnit loadUnitAndPostUnit(String codeUnit);
	
	void saveUnit(UnitAndPostUnit unitAndPostUnit);
	
	void updateUnit(UnitAndPostUnit unitAndPostUnit);
	
	void deleteUnit(String codeUnit);
}
