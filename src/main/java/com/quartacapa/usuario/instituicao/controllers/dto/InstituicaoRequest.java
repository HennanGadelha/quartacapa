package com.quartacapa.usuario.instituicao.controllers.dto;

import com.quartacapa.config.validacoes.uniqueValue.UniqueValue;
import com.quartacapa.usuario.instituicao.Instituicao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InstituicaoRequest {

    @NotNull @NotEmpty @NotBlank @UniqueValue(domainClass = Instituicao.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public InstituicaoRequest(){}

    public InstituicaoRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Instituicao toModel(){
        return new Instituicao(this.nome);
    }


}
