package com.metalsolutions.metal_solutions.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.metalsolutions.metal_solutions.enums.Cargo;
import com.metalsolutions.metal_solutions.enums.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data 
@Entity 
@Table(name = "funcionarios")
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
public abstract class Funcionario {
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Turno turno;
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Cargo cargo;
    private boolean ativo=true;
    @Setter(AccessLevel.NONE)
    @Column (name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;
}
