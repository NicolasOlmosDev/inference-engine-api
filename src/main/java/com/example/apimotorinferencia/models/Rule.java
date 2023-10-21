package com.example.apimotorinferencia.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Rule {
    static int nb = 0;
    public int nbr;
    private ArrayList<String> premiss;
    private String action;
    private Boolean active = true;
    
    static {
        nb += 1;
    }
    
    public Rule(ArrayList<String> premiss, String action) {
        this.nbr = nb;
        this.premiss = premiss;
        this.action = action;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public String toLog() {
        return "r" + this.nbr + "--> If: " + this.premiss.toString() + " , so: " + this.action;
    }
}
