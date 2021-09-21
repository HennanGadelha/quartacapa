package com.quartacapa.instituicao.controllers.dto;

import com.quartacapa.instituicao.model.Instituicao;

public class InstituicaoRequest {

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
