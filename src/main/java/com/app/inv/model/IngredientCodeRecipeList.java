package com.app.inv.model;

import java.io.Serializable;
import java.util.List;

public class IngredientCodeRecipeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1434184393201971248L;
	
	private List<IngredientCodeRecipe> ingredientCodeRecipeList;
	
	public IngredientCodeRecipeList(){
		
	}
	
	public IngredientCodeRecipeList(List<IngredientCodeRecipe> ingredientCodeRecipe){
		this.ingredientCodeRecipeList = ingredientCodeRecipe;
	}
	
	public List<IngredientCodeRecipe> getIngredientCodeRecipeList(){
		return ingredientCodeRecipeList;
	}
	
	public void setIngredientCodeRecipeList(List<IngredientCodeRecipe> ingredientCodeRecipe){
		this.ingredientCodeRecipeList = ingredientCodeRecipe;
	}
	

}
