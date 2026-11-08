package com.metalsolutions.metal_solutions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metalsolutions.metal_solutions.dto.AjudanteGeralRequestDTO;
import com.metalsolutions.metal_solutions.dto.AjudanteGeralResponseDTO;
import com.metalsolutions.metal_solutions.service.AjudanteGeralService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/ajudantes-gerais")
public class AjudanteGeralController {
    private final AjudanteGeralService ajudanteGeralService;
    
    private AjudanteGeralController(AjudanteGeralService ajudanteGeralService){
        this.ajudanteGeralService=ajudanteGeralService;
    }
    
    @PostMapping 
    public ResponseEntity<AjudanteGeralResponseDTO> criar(@RequestBody @Valid AjudanteGeralRequestDTO dto){
        AjudanteGeralResponseDTO response=ajudanteGeralService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
