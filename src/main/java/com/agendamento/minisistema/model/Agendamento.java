package com.agendamento.minisistema.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Table(name = "tb_agendamento")
public class Agendamento {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 120)
    private String titulo;

    @Column (columnDefinition = "TEXT")
    private String descricao;

    @Column (name = "data_inicio", nullable = false)
    private String data_inicio;

    @Column (name = "data_fim", nullable = false)
    private String data_fim;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false, length = 20)
    private StatusAgendamento status;

    @Column (nullable = false, length = 80)
    private String usuario;

    @Column (name = "criado_em", nullable = false)
    private String criado_em;

    @Column (name = "atualizado_em", nullable = false)
    private String atualizado_em;
}
