package com.quartacapa.usuario.instituicao.controllers.dto;

public class InstituicaoResponse {

    private String id;
    private String nome;

    @Deprecated
    public InstituicaoResponse(){}


    public InstituicaoResponse(String id, String nome) {
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
