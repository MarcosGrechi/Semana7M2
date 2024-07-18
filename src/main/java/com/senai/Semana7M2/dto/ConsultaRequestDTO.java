package com.senai.Semana7M2.dto;

import java.time.LocalDate;

public class ConsultaRequestDTO {
    private String observacoes;
    private LocalDate dataConsulta;

    // Getters e Setters
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}