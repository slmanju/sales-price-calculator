package com.slmanju.pricecalculator;

import java.util.List;

public class PriceCalculator {

    private Order order;
    private List<LineItem> lineItems;
    private LineItemWrapper lineItemWrapper;

    public PriceCalculator(Order order) {
        this.order = order;
        this.lineItems = order.getLineItems();
        this.lineItemWrapper = new LineItemWrapper(lineItems);
    }
    
    public int total() {
        lineItemWrapper.lines().forEach(line -> {
            System.out.println("Item: " + line.id());
            System.out.println("Price: " + line.startPrice());
            System.out.println("Discount: " + line.discountAmount());
            System.out.println("Discounted Amount: " + line.subtotal());
            System.out.println("Tax: " + line.taxAmount());
            System.out.println("Final Amount: " + line.amount());
            System.out.println("-----------------------------------");
        });
        
        return subtotal();
    }
    
    public void calculate() {
        int total =  subtotal();
        System.out.println(total);
    }
    
    public int subtotal() {
        return lineItems.stream().mapToInt(this::lineSubtotal).sum();
    }
    
    public int lineSubtotal(LineItem lineItem) {
        return lineItem.getPrice() * lineItem.getQuantity();
    }

}
