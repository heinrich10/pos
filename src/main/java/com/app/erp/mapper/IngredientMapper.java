package com.app.erp.mapper;

import java.util.List;
import java.util.Map;

import com.app.erp.model.IngredientCode;
import com.app.erp.model.IngredientLink;
import com.app.erp.model.IngredientType;
import com.app.erp.model.Inventory;

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
