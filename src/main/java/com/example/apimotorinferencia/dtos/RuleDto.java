package com.example.apimotorinferencia.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RuleDto {
    private ArrayList<String> premiss;
    private String action;
}
