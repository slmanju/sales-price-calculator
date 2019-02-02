package com.slmanju.pricecalculator;

public class LineItem {

    private String id;
    private int price;
    private int quantity;
    private int discount;
    
    public LineItem(String id, int price, int quantity, int discount) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
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

    public int getDiscount() {
        return discount;
    }

}
