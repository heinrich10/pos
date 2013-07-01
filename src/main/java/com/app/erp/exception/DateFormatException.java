package com.app.erp.exception;

public class DateFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4964684209664515024L;
	
	public DateFormatException(){
		System.out.println("Date format is invalid");
	}
}
