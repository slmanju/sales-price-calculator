package com.slmanju;

import java.util.Arrays;
import java.util.List;

import com.slmanju.pricecalculator.LineItem;
import com.slmanju.pricecalculator.Order;
import com.slmanju.pricecalculator.PriceCalculator;

public class Tester {

    public static void main(String[] args) {
        LineItem lineItem1 = new LineItem("1001", 120, 1, 0);
        LineItem lineItem2 = new LineItem("1002", 150, 2, 0);
        LineItem lineItem3 = new LineItem("1003", 100, 3, 0);
        
        List<LineItem> lineItems = Arrays.asList(lineItem1, lineItem2, lineItem3);
        
        Order order = new Order(lineItems);
        
        PriceCalculator calculator = new PriceCalculator(order);
        
        calculator.calculate();
    }

}
