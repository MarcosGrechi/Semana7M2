package com.senai.Semana7M2.dto;

public class NutricionistaResponseDTO {

    private Long id;
    private String crn;
    private String especialidade;

    // Construtores
    public NutricionistaResponseDTO() {
        // Construtor padrão
    }

    public NutricionistaResponseDTO(Long id, String crn, String especialidade) {
        this.id = id;
        this.crn = crn;
        this.especialidade = especialidade;
    }

    public NutricionistaResponseDTO(Long id, String nome, int tempoExperiencia) {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
