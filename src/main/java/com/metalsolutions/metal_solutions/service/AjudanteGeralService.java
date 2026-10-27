package com.metalsolutions.metal_solutions.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metalsolutions.metal_solutions.dto.AjudanteGeralRequestDTO;
import com.metalsolutions.metal_solutions.dto.AjudanteGeralResponseDTO;
import com.metalsolutions.metal_solutions.dto.QualificacaoResponseDTO;
import com.metalsolutions.metal_solutions.model.AjudanteGeral;
import com.metalsolutions.metal_solutions.model.Qualificacao;
import com.metalsolutions.metal_solutions.repository.AjudanteGeralRepository;
import com.metalsolutions.metal_solutions.repository.QualificacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class AjudanteGeralService {

    private final AjudanteGeralRepository ajudanteGeralRepository;
    private final QualificacaoRepository qualificacaoRepository;

    public AjudanteGeralService(
            AjudanteGeralRepository ajudanteGeralRepository,
            QualificacaoRepository qualificacaoRepository) {
        this.ajudanteGeralRepository = ajudanteGeralRepository;
        this.qualificacaoRepository = qualificacaoRepository;
    }

    @Transactional
    public AjudanteGeralResponseDTO criar(AjudanteGeralRequestDTO dto) {
        // buscar qualificacoes
        Set<Qualificacao> qualificacoes = new HashSet<>();
        if (dto.qualificacoesIds() != null && !dto.qualificacoesIds().isEmpty()) {
            qualificacoes = new HashSet<>(qualificacaoRepository.findAllById(dto.qualificacoesIds()));
            // validacao
            if (qualificacoes.size() != dto.qualificacoesIds().size()) {
                throw new RuntimeException("Uma ou mais qualificações informadas não foram encontradas no sistema.");
            }
        }

        // instanciar e preencher a entidade com dados do request dto
        AjudanteGeral ajudante = new AjudanteGeral();
        ajudante.setNome(dto.nome());
        ajudante.setCpf(dto.cpf());
        ajudante.setCargo(dto.cargo());
        ajudante.setSalario(dto.salario());
        ajudante.setTurno(dto.turno());

        // associar o conjunto
        ajudante.setQualificacoes(qualificacoes);

        // salvar no banco
        AjudanteGeral salvo = ajudanteGeralRepository.save(ajudante);

        // converter para response
        return converterParaResponse(salvo);
    }

    private AjudanteGeralResponseDTO converterParaResponse(AjudanteGeral entity){
            Set<QualificacaoResponseDTO> qualificacaoResponse=entity.getQualificacoes().stream()
            .map(q -> new QualificacaoResponseDTO(q.getId(), q.getNome(), q.getDescricao()))
            .collect(Collectors.toSet());

            return new AjudanteGeralResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getCargo(),
                entity.getTurno(),
                entity.isAtivo(), 
                entity.getSalario(),
                qualificacaoResponse
            );
        }
}
