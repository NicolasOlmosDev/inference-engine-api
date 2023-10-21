package com.example.apimotorinferencia.controllers;

import com.example.apimotorinferencia.dtos.SolveForwardChainingDto;
import com.example.apimotorinferencia.models.Rule;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/forward-chaining")
public class ForwardChainingController {

    @PostMapping("/solve")
    public String solve(@RequestBody SolveForwardChainingDto solveForwardChainingDto) {
        // Create a service to handle the request
        // this service will call the app.ChainageAvant.solve method
        return "Hello World";
    }
}
