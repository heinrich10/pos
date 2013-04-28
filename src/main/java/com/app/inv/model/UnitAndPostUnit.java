package com.app.inv.model;

public class UnitAndPostUnit extends Unit {
	
	private String codePostUnit;
	private String namePostUnit;
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
