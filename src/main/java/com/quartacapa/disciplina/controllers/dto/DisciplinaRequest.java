package com.quartacapa.disciplina.controllers.dto;

import com.quartacapa.config.validacoes.uniqueValue.UniqueValue;
import com.quartacapa.disciplina.model.Disciplina;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DisciplinaRequest {

    @NotNull @NotEmpty @NotBlank @UniqueValue(domainClass = Disciplina.class, fieldName = "nome")
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
