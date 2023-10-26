package com.example.apimotorinferencia.services;

import com.example.apimotorinferencia.dtos.RuleDto;
import com.example.apimotorinferencia.dtos.SolveForwardChainingDto;
import com.example.apimotorinferencia.models.KnowledgeBase;
import com.example.apimotorinferencia.models.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ForwardChainingService {

    public String solve(SolveForwardChainingDto solveForwardChainingDto) {
        String query = solveForwardChainingDto.getQuery();

        //Get facts
        ArrayList<String> facts = solveForwardChainingDto.getFacts();

        //Get knowledge base
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        for (RuleDto ruleDto : solveForwardChainingDto.getKnowledgeBase().getRules()) {
            Rule newRule = new Rule(ruleDto.getPremiss(), ruleDto.getAction());
            knowledgeBase.getRules().add(newRule);
        }

        //Solve
        return solveForwardChaining(facts, knowledgeBase, query);
    }

    private String solveForwardChaining(ArrayList<String> facts, KnowledgeBase knowledgeBase, String query) {
        StringBuilder result = new StringBuilder();
        ArrayList<Rule> newRules = new ArrayList<>();
        try {
            while (!facts.contains(query) && knowledgeBase.countApplicableRules(facts) > 0) {
                Rule applicableRule = knowledgeBase.getApplicableRule(facts);

                applicableRule.deactivate();

                System.out.println("La regla aplicable es: " + applicableRule.toLog() + "\n");
                result.append("La regla aplicable es: ").append(applicableRule.toLog()).append("\n");

                newRules.add(applicableRule);

                facts.add(applicableRule.getAction());
                System.out.println("Hechos para esta iteración: " + facts + "\n");
                result.append("Hechos para esta iteración: ").append(facts).append("\n");
            }

            if (facts.contains(query)) {
                System.out.println("La regla: " + query + " está establecida");
                result.append("La regla: ").append(query).append(" está establecida").append("\n");
                System.out.println("Las reglas utilizadas para demostrar {" + query + "}:");
                result.append("Las reglas utilizadas para demostrar {").append(query).append("}:").append("\n");
                for (Rule rule : newRules) {
                    System.out.println(rule.toLog());
                    result.append(rule.toLog()).append("\n");
                }
            } else {
                System.out.println("La regla: " + query + " no está establecida");
                result.append("La regla: ").append(query).append(" no está establecida").append("\n");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result.toString();
    }

}

