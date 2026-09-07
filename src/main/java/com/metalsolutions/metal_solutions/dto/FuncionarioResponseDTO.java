package com.metalsolutions.metal_solutions.dto;

import java.math.BigDecimal;

import com.metalsolutions.metal_solutions.enums.Cargo;
import com.metalsolutions.metal_solutions.enums.Turno;

public record FuncionarioResponseDTO (
    String nome,
    String cpf,
    Cargo cargo,
    BigDecimal salario,
    Turno turno
) {}
