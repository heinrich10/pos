package com.app.inv.model;

import java.io.Serializable;

public class IngredientLink implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -345836939997497312L;
	
	private String codeIngredient;
	private long link1;
	private long link2;
	
	public String getCodeIngredient() {
		return codeIngredient;
	}
	public void setCodeIngredient(String codeIngredient) {
		this.codeIngredient = codeIngredient;
	}
	public long getLink2() {
		return link2;
	}
	public void setLink2(long link2) {
		this.link2 = link2;
	}
	public long getLink1() {
		return link1;
	}
	public void setLink1(long link1) {
		this.link1 = link1;
	}
	
}
