package com.example.apimotorinferencia.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SolveForwardChainingDto {
    private String query;
    private ArrayList<String> facts;
    private KnowledgeBaseDto knowledgeBase;
}
