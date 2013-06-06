package com.app.inv.mapper;

import java.util.List;
import java.util.Map;

import com.app.inv.model.IngredientCode;
import com.app.inv.model.IngredientLink;
import com.app.inv.model.IngredientType;
import com.app.inv.model.Inventory;

public interface IngredientMapper {
    
    List<IngredientCode> loadIngredientCode();
    
    void saveIngredientCode(IngredientCode ingredientCode);
    
    void deleteIngredientCode(String[] code);
    
    List<IngredientType> loadIngredientType();
    
    void saveIngredientType(IngredientType ingredientType);
    
    void deleteIngredientType(String[] code);
    
    IngredientLink loadIngredientLink(String codeIngredient);
    
    Inventory loadIngredientLinkOne(String codeIngredient);
    
    Inventory loadIngredientLinkTwo(String codeIngredient);

    void saveIngredientLink(IngredientLink ingredientLink);
    
}
