package com.example.apimotorinferencia.models;

import java.util.ArrayList;

public class ForwardChaining {
    public static void solve(ArrayList<String> facts, KnowledgeBase knowledgeBase, String query) {
        ArrayList<Rule> newRules = new ArrayList<>();
        try {
            while (!facts.contains(query) && knowledgeBase.countApplicableRules(facts) > 0) {
                Rule applicableRule = knowledgeBase.getApplicableRule(facts);

                applicableRule.deactivate();

                System.out.println("The applicable rule is: " + applicableRule.toLog() + "\n");

                newRules.add(applicableRule);

                facts.add(applicableRule.getAction());
                System.out.println("Facts for this iteration: " + facts + "\n");
            }

            if (facts.contains(query)) {
                System.out.println("The rule: " + query + " is established");
                System.out.println("The rules used to demonstrate {" + query + "}:");
                for (Rule rule : newRules) {
                    System.out.println(rule.toLog());
                }
            } else {
                System.out.println("The rule: " + query + " is not established");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
