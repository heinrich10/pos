package com.app.erp.model;

import javax.validation.constraints.Min;

public class UnitAndPostUnit extends Unit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4691842932753831766L;
	private String codePostUnit;
	private String namePostUnit;
	@Min(0)
	private double conversionFactor;
	
	public void setCodePostUnit(String codePostUnit){
		this.codePostUnit = codePostUnit;
	}
	
	public String getCodePostUnit(){
		return codePostUnit;
	}
	
	public void setNamePostUnit(String namePostUnit){
		this.namePostUnit = namePostUnit;
	}
	
	public String getNamePostUnit(){
		return namePostUnit;
	}
	
	public void setConversionFactor(double conversionFactor){
		this.conversionFactor = conversionFactor;
	}
	
	public double getConversionFactor(){
		return conversionFactor;
	}

}
