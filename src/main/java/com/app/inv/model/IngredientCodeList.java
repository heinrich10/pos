/**
 * 
 */
package com.app.inv.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Heinrich
 *
 */
public class IngredientCodeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1434184393201971248L;
	
	private List<IngredientCode> ingredientCodeList;
	
	public IngredientCodeList(){
		
	}
	
	public IngredientCodeList(List<IngredientCode> ingredientCodeList){
		this.ingredientCodeList = ingredientCodeList;
	}
	
	public List<IngredientCode> getIngredientCodeList(){
		return ingredientCodeList;
	}
	
	public void setIngredientCodeList(List<IngredientCode> ingredientCodeList){
		this.ingredientCodeList = ingredientCodeList;
	}
}
