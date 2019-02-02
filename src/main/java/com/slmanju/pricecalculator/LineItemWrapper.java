package com.slmanju.pricecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class LineItemWrapper {
    
    public static BigDecimal HUNDRED = BigDecimal.valueOf(100);
    public static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    
    private List<Line> lines;

    public LineItemWrapper(List<LineItem> lineItems) {
        this.lines = lineItems.stream().map(lineItem -> {
            Line line = new Line();
            line.id = lineItem.getId();
            line.price = lineItem.getPrice();
            line.quantity = lineItem.getQuantity();
            line.discount = lineItem.getDiscount();
            line.taxes = lineItem.getTaxes();
            return line;
        }).collect(Collectors.toList());
    }
    
    public List<Line> lines() {
        return lines;
    }
    
    public static class Line {
        private String id;
        private int price;
        private int quantity;
        private int discount;
        private List<Tax> taxes;
        
        public String id() {
            return id;
        }
        
        public BigDecimal startPrice() {
            return BigDecimal.valueOf(price * quantity);
        }
        
        public BigDecimal subtotal() {
            return startPrice().subtract(discountAmount());
        }
    
        public BigDecimal discountAmount() {
            return startPrice()
                    .multiply(BigDecimal.valueOf(discount))
                    .divide(HUNDRED)
                    .setScale(2, ROUNDING_MODE);
        }
        
        public BigDecimal taxAmount() {
            BigDecimal amount = taxes.stream().map(this::tax)
                            .reduce(BigDecimal.ZERO, (result, source) -> result.add(source));
            return amount;
        }

        public BigDecimal tax(Tax tax) {
            BigDecimal returnValue = subtotal()
                    .multiply(BigDecimal.valueOf(tax.getPercentage()))
                    .divide(HUNDRED)
                    .setScale(2, ROUNDING_MODE);
            return returnValue;
        }
        
        public BigDecimal amount() {
            return startPrice()
                    .subtract(discountAmount())
                    .add(taxAmount());
        }
        
    }
    
}
