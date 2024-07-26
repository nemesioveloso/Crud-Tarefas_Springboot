package com.sefaz.tarefa.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ABERTA,
        EM_ANDAMENTO,
        CONCLUIDA
    }

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        if (status == Status.CONCLUIDA) {
            dataConclusao = LocalDateTime.now();
        }
    }
}