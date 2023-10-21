package com.example.apimotorinferencia.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class KnowledgeBase {
    private ArrayList<Rule> rules;

    public Rule getApplicableRule(ArrayList<String> facts) throws Exception {
        Rule applicableRule = null;
        for (Rule rule : this.rules) {
            if (rule.getActive() && facts.containsAll(rule.getPremiss())) {
                applicableRule = rule;
                break;
            }
        }

        if (applicableRule == null) {
            // Throw an exception if the rule is not found
            throw new Exception("Error, no base");
        }

        return applicableRule;
    }

    public int countApplicableRules(ArrayList<String> facts) {
        int counter = 0;
        for (Rule rule : this.rules) {
            if (rule.getActive() && facts.containsAll(rule.getPremiss())) {
                counter++;
                break;
            }
        }
        return counter;
    }
}
