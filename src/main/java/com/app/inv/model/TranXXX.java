package com.app.inv.model;

public class TranXXX {
	
	private OrderList orderList;
    private double recievedAmount = 0;
    private double change = 0;
    private boolean indDineIn = true;
    private long tranId;
    
    public TranXXX(){
        orderList = new OrderList();
    }
    
    public double calculateChange(double recievedAmount, double price){
        this.recievedAmount = recievedAmount;
        return change = recievedAmount - price;
    }
    
    public double getRecievedAmount(){
        return recievedAmount;
    }
    
    public double getChange(){
        return change;
    }
    
    public OrderList getOrderList(){
        return orderList;
    }
    
    public boolean getDineIn(){
        return indDineIn;
    }
    
    public void reset(){
        orderList.reset();
        recievedAmount = 0;
        change = 0;
        indDineIn = true;
    }
    
    public void addMenuItem(MenuItem menuItem){
        orderList.addMenuItem(menuItem);
    }
    
    public void voidMenuItem(int index){
        orderList.removeMenuItem(index);
    }
    
    public void setDineIn(boolean indDineIn){
        this.indDineIn = indDineIn;
    }
    
    public void setTranId(long tranId){
        this.tranId = tranId;
    }
    
    public long getTranId(){
        return tranId;
    }
}
