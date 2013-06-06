package com.app.erp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.app.erp.mapper.MenuItemMapper;
import com.app.erp.mapper.RecipeMapper;
import com.app.erp.mapper.UnitMapper;
import com.app.erp.model.Ingredient;
import com.app.erp.model.IngredientCodeRecipe;
import com.app.erp.model.IngredientCodeRecipeList;
import com.app.erp.model.MenuItemList;
import com.app.erp.model.Recipe;
import com.app.erp.model.Unit;

public class RecipeService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5836265296175329335L;
	/**
	 * 
	 */
	
	@Inject
	private transient RecipeMapper recipeMapper;
	
	@Inject
	private transient MenuItemMapper menuItemMapper;
	
	@Inject
	private transient UnitMapper unitMapper;
	
	public RecipeService(){
		
	}
	
	public MenuItemList loadMenuItemList(){
		return new MenuItemList(menuItemMapper.loadMenuItem());
	}
	
	public IngredientCodeRecipeList loadIngredientCode(String codeMenu){
		
		List<IngredientCodeRecipe> arrIngredientCodeRecipe = recipeMapper.loadIngredientCodeRecipe();
		Map<String, IngredientCodeRecipe> ingredientCodeMap = new HashMap<String, IngredientCodeRecipe>();
		
		for(IngredientCodeRecipe ingredientCodeRecipe:arrIngredientCodeRecipe){
			ingredientCodeMap.put(ingredientCodeRecipe.getCode(), ingredientCodeRecipe);
		}
		
		List<Ingredient> arrIngredient = recipeMapper.loadRecipe(codeMenu);
		if(arrIngredient != null){
			for(Ingredient ingredient:arrIngredient){
				ingredientCodeMap.get(ingredient.getCodeIngredient()).setSelected(true);
			}
		}
		
		arrIngredientCodeRecipe = new ArrayList<IngredientCodeRecipe>(ingredientCodeMap.values());
		
		return new IngredientCodeRecipeList(arrIngredientCodeRecipe);
	}
	
	public Recipe forIngredientValue(
			IngredientCodeRecipeList ingredientCodeRecipeList,
			String codeMenu){
		List<IngredientCodeRecipe> arrIngredientCodeRecipe = ingredientCodeRecipeList.getIngredientCodeRecipeList();
		List<Ingredient> arrIngredient = recipeMapper.loadRecipe(codeMenu);
		if(arrIngredient != null){
			Map<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();
			for(Ingredient ingredient:arrIngredient){
				ingredientMap.put(ingredient.getCodeIngredient(), ingredient);
			}
		
			List<Ingredient> arrNewIngredient = new ArrayList<Ingredient>();
			List<Ingredient> arrRemIngredient = new ArrayList<Ingredient>();
			for(IngredientCodeRecipe ingredientCodeRecipe:arrIngredientCodeRecipe){
				Ingredient ing = ingredientMap.get(ingredientCodeRecipe.getCode());
				if(ingredientCodeRecipe.getSelected()){
					if(ing == null){
						arrNewIngredient.add(new Ingredient(codeMenu, ingredientCodeRecipe.getCode(), ingredientCodeRecipe.getName()));
					} 
				} else {
					if(ing != null){
						arrRemIngredient.add(ing);
					}
				}
			}
			
				arrIngredient.addAll(arrNewIngredient);
				arrIngredient.removeAll(arrRemIngredient);
		}
		return new Recipe(arrIngredient);
	}
	
	public void saveRecipe(Recipe recipe){
		List<Ingredient> arrIngredient = recipe.getIngredientList();
		for(Ingredient ingredient:arrIngredient){
			recipeMapper.saveRecipe(ingredient);
		}
		
	}
	
	public List<Unit> getUnits(){
		return unitMapper.loadUnit();
	}
}
