package com.app.inv.model;

public class Discount {

    private String codeDiscount;
    private String name;
    private double discountFactor;
    private boolean indVatable;
    
    public Discount(){
    	
    }
    
    public Discount(String codeDiscount, String name, double discountFactor, boolean indVatable){
        this.codeDiscount = codeDiscount;
        this.name = name;
        this.discountFactor = discountFactor;
        this.indVatable = indVatable;
    }
    
    public String getCodeDiscount() {
        return codeDiscount;
    }
    
    public void setCodeDiscount(String codeDiscount){
        this.codeDiscount = codeDiscount;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getDiscountFactor(){
        return discountFactor;
    }
    
    public void setDiscountFactor(double discountFactor){
        this.discountFactor = discountFactor;
    }
    
    public boolean getIndVatable(){
        return indVatable;
    }
    
    public void setIndVatable(boolean indVatable){
        this.indVatable = indVatable;
    }
}

