package com.agendamento.minisistema.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import com.agendamento.minisistema.model.*;
import com.agendamento.minisistema.dto.AgendamentoCreateRequest;
import com.agendamento.minisistema.dto.AgendamentoResponse;
import com.agendamento.minisistema.dto.AgendamentoUpdateRequest;
import com.agendamento.minisistema.mapper.AgendamentoMapper;
import com.agendamento.minisistema.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service  
@RequiredArgsConstructor 
public class AgendamentoService {
    private final AgendamentoRepository repo;

    @Transactional 
    public AgendamentoResponse criar(AgendamentoCreateRequest req){
        validarIntervalo(req.dataInicio(), req.dataFim());
        checarConflito(req.usuario(), req.dataInicio(), req.dataFim(), null);
        Agendamento entity = AgendamentoMapper.toEntity(req);
        entity = repo.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }
    
    @Transactional 
    public AgendamentoResponse atualizar(Long id, AgendamentoUpdateRequest req){
        Agendamento entity = repo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Entidade nao encontrada no banco de dados"));
        AgendamentoMapper.merge(entity, req);
        validarIntervalo(req.dataInicio(), req.dataFim());
        checarConflito(entity.getUsuario(), req.dataInicio(), req.dataFim(), entity.getId());
        AgendamentoResponse response = AgendamentoMapper.toResponse(entity);
        repo.save(entity);
        return response;
    }

    @Transactional 
    public AgendamentoResponse cancelar(Long id){
        Agendamento entity = repo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Entidade nao encontrada no banco de dados"));
        entity.setStatus(StatusAgendamento.CANCELADO);
        repo.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional
    public AgendamentoResponse concluir(Long id){
        Agendamento entity = repo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Entidade nao encontradao no bando de dados"));
        entity.setStatus(StatusAgendamento.CONCLUIDO);
        repo.save(entity);
        return AgendamentoMapper.toResponse(entity);
    }

    @Transactional 
    public AgendamentoResponse buscarPorId(Long id){
        Agendamento entity = repo.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Entidade nao encontradao no bando de dados"));
        return AgendamentoMapper.toResponse(entity);
    }

    private void validarIntervalo(LocalDateTime inicio, LocalDateTime fim){
        if (inicio == null || fim == null || inicio.isBefore(fim)) {
            throw new IllegalArgumentException("Intervalo invalido, dataInicio deve ser anterior a dataFim");
        }
    }

    private void checarConflito(String usuario, LocalDateTime inicio, LocalDateTime fim, Long id){
        if (repo.existeConflito(usuario, inicio, fim, id)) {
            throw new IllegalArgumentException("Conflito na agenda: ja existe um agendamento nesse periodo");
        }
    }
}
