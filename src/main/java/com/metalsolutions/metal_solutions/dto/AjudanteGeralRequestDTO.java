package com.metalsolutions.metal_solutions.dto;

import java.math.BigDecimal;

import com.metalsolutions.metal_solutions.enums.Cargo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Set;

public record AjudanteGeralRequestDTO(
    @NotBlank (message = "O campo 'nome' é obrigatório") String nome,
    @NotBlank (message = "O campo 'cpf' é obrigatório") String cpf,
    @NotNull (message = "O campo 'cargo' é obrigatório") Cargo cargo,
    @NotNull (message = "O campo 'salario' é obrigatório") 
    @Positive (message = "O campo 'salario' deve ser um valor positivo") BigDecimal salario,
    @NotNull (message = "O campo 'turno' é obrigatório") String turno,
    Set<Long> qualificacoes
) {}
