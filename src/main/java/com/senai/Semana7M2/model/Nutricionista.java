package com.senai.Semana7M2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crn;
    private String especialidade;

    @Column(name = "tempoExperiencia") // Mapeando o nome da coluna no banco de dados
    private int tempoExperiencia;

    // Construtores
    public Nutricionista() {
    }

    public Nutricionista(Long id, String nome, String crn, String especialidade, int tempoExperiencia) {
        this.id = id;
        this.nome = nome;
        this.crn = crn;
        this.especialidade = especialidade;
        this.tempoExperiencia = tempoExperiencia;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Nutricionista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crn='" + crn + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", tempoExperiencia=" + tempoExperiencia +
                '}';
    }
}
