package com.slmanju.pricecalculator;

public class LineItem {

    private String id;
    private int price;
    private int quantity;
    private int grossTotal;
    private int calculatedAmount;
    
    public LineItem(String id, int price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int grossTotal() {
        grossTotal = price * quantity;
        return grossTotal;
    }

    public int getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(int calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

}
