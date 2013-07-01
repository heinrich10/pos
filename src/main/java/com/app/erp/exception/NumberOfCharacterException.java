package com.app.erp.exception;

public class NumberOfCharacterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4540503124249221579L;
	
	public NumberOfCharacterException(){
		System.out.println("Input exceeds the maximum allowable character");
	}
}
