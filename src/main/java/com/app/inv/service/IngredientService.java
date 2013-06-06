package com.app.inv.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.app.inv.mapper.IngredientMapper;
import com.app.inv.model.IngredientCodeList;
import com.app.inv.model.IngredientLink;

public class IngredientService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5761957303785995228L;
	
	@Inject
	private transient IngredientMapper ingredientMapper;
	
	public IngredientCodeList loadIngredientCode(){
		
		return new IngredientCodeList(ingredientMapper.loadIngredientCode());
		
	}
	
	public IngredientLink loadIngredientLink(String codeIngredient){
		
		IngredientLink ingredientLink = ingredientMapper.loadIngredientLink(codeIngredient);
		
		if(ingredientLink == null){
			ingredientLink = new IngredientLink();
			//ingredientLink.setLink1(0);
			//ingredientLink.setLink2(0);
		}
		ingredientLink.setCodeIngredient(codeIngredient);
		
		return ingredientLink;
	}
	
	public void validate(IngredientLink ingredientLink) throws Exception{
		long itemNumber1 = ingredientLink.getLink1();
		long itemNumber2 = ingredientLink.getLink2();
		if(itemNumber1 == 0 && itemNumber2 == 0){
			
		}else if(itemNumber1 == itemNumber2){
			throw new Exception();
		}
	}
	
	public void saveIngredientLink(IngredientLink ingredientLink){
		
		ingredientMapper.saveIngredientLink(ingredientLink);
	}
	
}
