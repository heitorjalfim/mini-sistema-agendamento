package com.agendamento.minisistema.mapper;

import com.agendamento.minisistema.model.*;
import java.time.LocalDateTime;
import com.agendamento.minisistema.dto.AgendamentoCreateRequest;
import com.agendamento.minisistema.dto.AgendamentoResponse;
import com.agendamento.minisistema.dto.AgendamentoUpdateRequest;

public class AgendamentoMapper {
    public static Agendamento toEntity(AgendamentoCreateRequest req) {
        return Agendamento.builder()
        .titulo(req.titulo())
        .descricao(req.descricao())
        .dataInicio(req.dataInicio())
        .dataFim(req.dataFim())
        .usuario(req.usuario())
        .status(StatusAgendamento.AGENDADO)
        .criadoEm(LocalDateTime.now())
        .atualizadoEm(LocalDateTime.now())
        .build();
    }

    public static void merge(Agendamento entity, AgendamentoUpdateRequest req){
        if (req.titulo() != null) {
            entity.setTitulo(req.titulo());
        }
        if (req.descricao() != null) {
            entity.setDescricao(req.descricao());
        }
        if (req.dataInicio() != null) {
            entity.setDataInicio(req.dataInicio());
        }
        if (req.dataFim() != null) {
            entity.setDataFim(req.dataFim());
        }
    }

    public static AgendamentoResponse toResponse(Agendamento a){
        return new AgendamentoResponse(
            a.getId(), 
            a.getTitulo(),
            a.getDescricao(),
            a.getDataInicio(),
            a.getDataFim(),
            a.getStatus(),
            a.getUsuario(),
            a.getCriadoEm(),
            a.getCriadoEm());
    }
}
