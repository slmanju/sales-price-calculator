package com.slmanju;

import java.util.Arrays;
import java.util.List;

import com.slmanju.pricecalculator.LineItem;
import com.slmanju.pricecalculator.Order;
import com.slmanju.pricecalculator.PriceCalculator;
import com.slmanju.pricecalculator.Tax;

public class Tester {

    public static void main(String[] args) {
        Tax tax1 = Tax.of("T101", 2);
        Tax tax2 = Tax.of("T101", 1);
        LineItem lineItem1 = new LineItem("1001", 100, 1, 10, Arrays.asList(tax1));
        LineItem lineItem2 = new LineItem("1002", 150, 2, 0, Arrays.asList(tax1, tax2));
        
        List<LineItem> lineItems = Arrays.asList(lineItem1, lineItem2);
        
        Order order = new Order(lineItems);
        
        PriceCalculator calculator = new PriceCalculator(order);
        
        calculator.total();
    }

}
