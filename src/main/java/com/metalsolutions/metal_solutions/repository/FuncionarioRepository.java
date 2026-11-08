package com.metalsolutions.metal_solutions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metalsolutions.metal_solutions.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    Optional<Funcionario> findByCpf(String cpf);
}
