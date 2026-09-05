package com.metalsolutions.metal_solutions.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.metalsolutions.metal_solutions.enums.Cargo;
import com.metalsolutions.metal_solutions.enums.Turno;

public record AjudanteGeralResponseDTO(
    Long id,
    String nome,
    String cpf,
    Cargo cargo,
    Turno turno,
    BigDecimal salario,
    Set<QualificacaoResponseDTO> qualificacoes
) {}
