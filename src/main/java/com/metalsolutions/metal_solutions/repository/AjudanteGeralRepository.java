package com.metalsolutions.metal_solutions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metalsolutions.metal_solutions.model.AjudanteGeral;

public interface AjudanteGeralRepository extends JpaRepository<AjudanteGeral, Long>{
    @Query ("SELECT a FROM AjudanteGeral a LEFT JOIN FETCH a.qualificacoes WHERE a.id=:id")
    Optional<AjudanteGeral> findByIdComQualificacoes(@Param("id") Long id);
}
