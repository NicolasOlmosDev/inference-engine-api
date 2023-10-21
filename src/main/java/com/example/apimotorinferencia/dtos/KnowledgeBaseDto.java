package com.example.apimotorinferencia.dtos;

import lombok.Data;

@Data
public class KnowledgeBaseDto {
    private String[] premiss;
    private String action;
}
