package com.quartacapa.usuario.controllers.dto.response;

import com.quartacapa.anuncios.model.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponse {

    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCelular;

    private List<Anuncio> anuncios= new ArrayList<Anuncio>();

    @Deprecated
    public UsuarioResponse(){}


    public UsuarioResponse(String id, String nome, String email,String cpf, String numeroCelular, List<Anuncio> anuncios) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.anuncios = anuncios;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }
}