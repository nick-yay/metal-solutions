package com.metalsolutions.metal_solutions.model;

import com.metalsolutions.metal_solutions.enums.NivelAcesso;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@EqualsAndHashCode (callSuper = true)
@Table (name = "rh")
@PrimaryKeyJoinColumn(name = "funcionario_id")
public final class RH extends Funcionario{
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_acesso", nullable = false)
    private NivelAcesso nivelAcesso;
}
