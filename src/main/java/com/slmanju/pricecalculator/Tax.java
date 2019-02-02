package com.slmanju.pricecalculator;

public class Tax {
    
    private String id;
    private int percentage;
    
    private Tax(String id, int percentage) {
        this.id = id;
        this.percentage = percentage;
    }
    
    public static Tax of(String id, int percentage) {
        return new Tax(id, percentage);
    }

    public String getId() {
        return id;
    }

    public int getPercentage() {
        return percentage;
    }

}
