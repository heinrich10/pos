package com.app.erp.model;

import java.io.Serializable;

public class IngredientCodeRecipe extends IngredientCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -514093795270825292L;
	private Boolean selected = false;
	

    public Boolean getSelected(){
    	return selected;
    }
    
    public void setSelected(Boolean selected){
    	this.selected = selected;
    }
}
