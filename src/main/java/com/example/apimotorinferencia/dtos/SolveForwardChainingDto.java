package com.example.apimotorinferencia.dtos;

import lombok.Data;

@Data
public class SolveForwardChainingDto {
    private String query;
    private String[] facts;
    private KnowledgeBaseDto[] knowledgeBase;
}
