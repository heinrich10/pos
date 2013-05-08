package com.app.inv.mapper;

import java.util.List;

import com.app.inv.model.Ingredient;
import com.app.inv.model.IngredientCodeRecipe;

public interface RecipeMapper {
	
	List<Ingredient> loadRecipe(String codeMenu);
	
	List<IngredientCodeRecipe> loadIngredientCodeRecipe();
	
	void saveRecipe(Ingredient ingredient);
	
}
