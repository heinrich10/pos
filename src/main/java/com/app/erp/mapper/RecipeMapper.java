package com.app.erp.mapper;

import java.util.List;

import com.app.erp.model.Ingredient;
import com.app.erp.model.IngredientCodeRecipe;

public interface RecipeMapper {
	
	List<Ingredient> loadRecipe(String codeMenu);
	
	List<IngredientCodeRecipe> loadIngredientCodeRecipe();
	
	void saveRecipe(Ingredient ingredient);
	
}
