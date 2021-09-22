package com.quartacapa.disciplina.controllers.dto;

import com.quartacapa.disciplina.model.Disciplina;

public class DisciplinaRequest {

    private String nome;

    @Deprecated
    public DisciplinaRequest(){}

    public DisciplinaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Disciplina toModel(){
        return new Disciplina(this.nome);
    }
}
