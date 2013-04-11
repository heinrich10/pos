package com.app.inv.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.inv.model.IngredientCode;
import com.app.inv.model.IngredientType;
import com.app.inv.model.Inventory;

public interface IngredientMapper {
    
    ArrayList<IngredientCode> loadIngredientCode();
    
    ArrayList<IngredientType> loadIngredientType();
    
    Inventory loadIngredientLinkOne(String codeIngredient);
    
    Inventory loadIngredientLinkTwo(String codeIngredient);
    
    void saveIngredientCode(IngredientCode ingredientCode);
    
    void deleteIngredientCode(String code);
    
    void saveInventoryLink(HashMap map);
}
