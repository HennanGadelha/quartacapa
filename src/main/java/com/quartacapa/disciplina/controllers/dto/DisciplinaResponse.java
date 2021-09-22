package com.quartacapa.disciplina.controllers.dto;

public class DisciplinaResponse {

    private String id;
    private String nome;

    @Deprecated
    public DisciplinaResponse(){}


    public DisciplinaResponse(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
