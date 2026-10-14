package com.agendamento.minisistema.controller;

import org.springframework.web.bind.annotation.RestController;
import com.agendamento.minisistema.dto.AgendamentoCreateRequest;
import com.agendamento.minisistema.dto.AgendamentoResponse;
import com.agendamento.minisistema.dto.AgendamentoUpdateRequest;
import com.agendamento.minisistema.service.AgendamentoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequiredArgsConstructor 
@Validated 
@RequestMapping("api/agendamentos")
public class AgendamentoController {
    private final AgendamentoService service;

    @PostMapping
    public AgendamentoResponse criar(@Valid @RequestBody AgendamentoCreateRequest req){
        return service.criar(req);
    }

    @PutMapping("/{id}")
    public AgendamentoResponse atualizar(@PathVariable Long id, @RequestBody AgendamentoUpdateRequest req){
        return service.atualizar(id, req);
    }

    @PutMapping("/{id}/cancelar")
    public AgendamentoResponse cancelar(@PathVariable Long id){
        return service.cancelar(id);
    }

    @PutMapping("/{id}/concluir")
    public AgendamentoResponse concluir(@PathVariable Long id) {
        return service.concluir(id);
    }

    @GetMapping("/{id}")
    public AgendamentoResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    
}
