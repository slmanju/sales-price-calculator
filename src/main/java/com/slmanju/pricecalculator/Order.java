package com.slmanju.pricecalculator;

import java.util.List;

public class Order {
    
    private List<LineItem> lineItems;

    public Order(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

}
