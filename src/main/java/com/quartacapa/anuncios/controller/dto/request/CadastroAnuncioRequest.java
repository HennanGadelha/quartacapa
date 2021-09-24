package com.quartacapa.anuncios.controller.dto.request;

import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.usuario.model.Usuario;

public class CadastroAnuncioRequest {


    private String titulo;
    private String descricao;
    private String fotoLivro;
    private String idLivro;
    private String idUsuario;

    public CadastroAnuncioRequest(){}

    public CadastroAnuncioRequest(String titulo, String descricao, String fotoLivro, String idLivro, String idUsuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.fotoLivro = fotoLivro;
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
    }


    public Anuncio toModel (Livro livro, Usuario usuario){
        return new Anuncio(this.titulo, this.descricao,livro,usuario, this.fotoLivro);
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFotoLivro() {
        return fotoLivro;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }
}
