package com.app.inv.model;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
private List<MenuItem> arrMenuItem;
    
    public OrderList(){
        
        arrMenuItem = new ArrayList<MenuItem>();
    }
    
    public void addMenuItem(MenuItem menuItem){
        arrMenuItem.add(menuItem);
    }
    
    public void removeMenuItem(int index){
        arrMenuItem.remove(index);
    }
    
    public MenuItem getMenuItem(int index){
        return arrMenuItem.get(index);
    }
    
    public int size(){
        return arrMenuItem.size();
    }
    
    public void reset(){
        arrMenuItem.clear();
    }

    public List<MenuItem> toArrayList(){
        return arrMenuItem;
    }
}
