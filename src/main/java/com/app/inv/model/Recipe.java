package com.app.inv.model;

import java.util.ArrayList;

public class Recipe {
private ArrayList<Ingredient> arrIngredient;
    
    public Recipe(){
        arrIngredient = new ArrayList();
    }
    
    public void addIngredient(Ingredient ingredient){
        arrIngredient.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient){
        arrIngredient.remove(ingredient);
    }
    
    public Ingredient removeIngredient(int index){
        return arrIngredient.remove(index);
    }
    
    public Ingredient getIngredient(int index){
        return arrIngredient.get(index);
    }
    
    public int size(){
        return arrIngredient.size();
    }
    
    public void replace(int index, Ingredient ingredient){
        arrIngredient.set(index, ingredient);
    }
}
