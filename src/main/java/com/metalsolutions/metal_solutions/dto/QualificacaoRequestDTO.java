package com.metalsolutions.metal_solutions.dto;

import jakarta.validation.constraints.NotBlank;

public record QualificacaoRequestDTO(
    @NotBlank (message = "O campo 'nome' é obrigatório") String nome,
    String descricao
) {}
