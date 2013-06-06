package com.app.erp.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 9199123488689936218L;
	private List<Ingredient> ingredientList;
    
	public Recipe(){
		
	}
	
    public Recipe(List<Ingredient> ingredientList){
    	this.ingredientList = ingredientList;
    }
    
    public void addIngredient(Ingredient ingredient){
    	ingredientList.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient){
    	ingredientList.remove(ingredient);
    }
    
    public Ingredient removeIngredient(int index){
        return ingredientList.remove(index);
    }
    
    public Ingredient getIngredient(int index){
        return ingredientList.get(index);
    }
    
    public int size(){
        return ingredientList.size();
    }
    
    public void replace(int index, Ingredient ingredient){
    	ingredientList.set(index, ingredient);
    }
    
    public List<Ingredient> getIngredientList(){
    	return ingredientList;
    }
}
