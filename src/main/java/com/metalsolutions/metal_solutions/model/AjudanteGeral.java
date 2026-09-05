package com.metalsolutions.metal_solutions.model;

import jakarta.persistence.JoinColumn;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@EqualsAndHashCode (callSuper = true)
@Entity 
@Table (name = "ajudante_geral")
@PrimaryKeyJoinColumn(name = "funcionario_id")
public final class AjudanteGeral extends Funcionario{
    @ManyToMany 
    @JoinTable(
        name="ajudante_qualificacao",
        joinColumns = @JoinColumn(name="ajudante_id"),
        inverseJoinColumns = @JoinColumn(name="qualificacao_id")
    )
    private Set<Qualificacao> qualificacoes;
}
