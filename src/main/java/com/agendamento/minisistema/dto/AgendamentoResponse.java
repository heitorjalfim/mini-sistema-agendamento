package com.agendamento.minisistema.dto;

import java.time.LocalDateTime;
import com.agendamento.minisistema.model.StatusAgendamento;

public record AgendamentoResponse(
    Long id,
    String titulo,
    String descricao,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    StatusAgendamento status,
    String usuario, 
    LocalDateTime criadoEm,
    LocalDateTime atualizadoEm
) {
}
