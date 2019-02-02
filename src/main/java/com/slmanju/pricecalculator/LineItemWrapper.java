package com.slmanju.pricecalculator;

import java.util.List;
import java.util.stream.Collectors;

public class LineItemWrapper {
    
    private List<Line> lines;

    public LineItemWrapper(List<LineItem> lineItems) {
        this.lines = lineItems.stream().map(lineItem -> {
            Line line = new Line();
            line.id = lineItem.getId();
            line.price = lineItem.getPrice();
            line.quantity = lineItem.getQuantity();
            line.startPrice = lineItem.getPrice() * lineItem.getQuantity();
            return line;
        }).collect(Collectors.toList());
    }
    
    public static class Line {
        private String id;
        private int price;
        private int quantity;
        private int startPrice;
    }
    
}
