package com.metalsolutions.metal_solutions.model;

import java.time.LocalDateTime;

import com.metalsolutions.metal_solutions.enums.StatusProduto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Getter 
@Setter 
@NoArgsConstructor 
@Entity
@Table(name = "ordens_producao") 
@Inheritance (strategy = jakarta.persistence.InheritanceType.JOINED)
public sealed class OrdemProducao permits EtapaProcesso{
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private Integer quantidade;
    private String descricao;
    private StatusProduto status; // PENDENTE, EM_ANDAMENTO, CONCLUIDO, CANCELADO  
    @Setter (AccessLevel.NONE)
    @Column (name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime criadoEm;

    public OrdemProducao(String produto, Integer quantidade, String descricao, StatusProduto status) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.status = status;
        this.criadoEm = LocalDateTime.now();
    }
}
