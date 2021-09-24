package com.quartacapa.anuncios.controller.dto.request;

public class AlterarAnuncioRequest {


    private String titulo;
    private String descricao;
    private String fotoLivro;

    @Deprecated
    public AlterarAnuncioRequest(){}

    public AlterarAnuncioRequest(String titulo, String descricao, String fotoLivro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.fotoLivro = fotoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoLivro() {
        return fotoLivro;
    }

    public void setFotoLivro(String fotoLivro) {
        this.fotoLivro = fotoLivro;
    }
}
