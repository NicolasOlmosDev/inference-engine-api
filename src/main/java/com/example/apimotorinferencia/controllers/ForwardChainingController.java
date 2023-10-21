package com.example.apimotorinferencia.controllers;

import com.example.apimotorinferencia.dtos.SolveForwardChainingDto;
import com.example.apimotorinferencia.services.ForwardChainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/forward-chaining")
public class ForwardChainingController {
    private final ForwardChainingService forwardChainingService;

    @Autowired
    public ForwardChainingController(ForwardChainingService forwardChainingService) {
        this.forwardChainingService = forwardChainingService;
    }

    @PostMapping("/solve")
    public String solve(@RequestBody SolveForwardChainingDto solveForwardChainingDto) {
        // Create a service to handle the request
        // this service will call the app.ChainageAvant.solve method
        return this.forwardChainingService.solve(solveForwardChainingDto);
    }
}
