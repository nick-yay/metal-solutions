package com.metalsolutions.metal_solutions.dto;

import com.metalsolutions.metal_solutions.enums.NivelAcesso;
import com.metalsolutions.metal_solutions.enums.Turno;
import com.metalsolutions.metal_solutions.enums.Cargo;
import java.math.BigDecimal;

public record RHResponseDTO(
    Long id,
    String nome,
    String cpf,
    Cargo cargo,
    Turno turno,
    BigDecimal salario,
    NivelAcesso nivelAcesso
) {}
