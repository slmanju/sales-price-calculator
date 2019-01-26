package com.slmanju.pricecalculator;

import java.util.List;

public class TotalRule implements Rule {
    
    private List<Rule> rules;
    
    public TotalRule(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public void execute() {
        rules.forEach(Rule::execute);
    }

}
