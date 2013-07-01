package com.app.erp.exception;

public class PatternException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4100657227250500002L;
	
	public PatternException(){
		System.out.println("Input does not comply with the pattern required");
	}
	
}
