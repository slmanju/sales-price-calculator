package com.slmanju.pricecalculator;

import java.util.List;

public class GrossTotalRule implements Rule {
    
    private List<LineItem> lineItems;

    public GrossTotalRule(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void execute() {
        lineItems.forEach(lineItem -> {
            int value = lineItem.grossTotal();
            lineItem.setCalculatedAmount(value);
        });
    }

}
