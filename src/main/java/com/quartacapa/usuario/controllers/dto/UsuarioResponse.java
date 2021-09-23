package com.quartacapa.usuario.controllers.dto;

public class UsuarioResponse {

    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCelular;

    @Deprecated
    public UsuarioResponse(){}


    public UsuarioResponse(String id, String nome, String email,String cpf, String numeroCelular) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
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
}