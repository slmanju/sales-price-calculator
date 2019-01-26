package com.slmanju.pricecalculator;

import java.util.Arrays;
import java.util.List;

public class PriceCalculator {

    private Order order;
    private List<Rule> rules;

    public PriceCalculator(Order order, Rule... rules) {
        this.order = order;
        this.rules = Arrays.asList(rules);
    }
    
    public void calculate() {
        Rule rule = new TotalRule(rules);
        rule.execute();
        
        int total =  order.getLineItems()
                .stream()
                .map(lineItem -> lineItem.getCalculatedAmount())
                .reduce(0, (result, current) -> result + current);
        System.out.println(total);
    }

}
