package com.example.apimotorinferencia.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class KnowledgeBaseDto {
    private ArrayList<RuleDto> rules;
}
