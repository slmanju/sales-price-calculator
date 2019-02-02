package com.slmanju.pricecalculator;

import java.util.List;

public class LineItem {

    private String id;
    private int price;
    private int quantity;
    private int discount;
    private List<Tax> taxes;
    
    public LineItem(String id, int price, int quantity, int discount, List<Tax> taxes) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.taxes = taxes;
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

    public List<Tax> getTaxes() {
        return taxes;
    }

}
