package com.quartacapa.usuario.controllers.dto;

import com.quartacapa.usuario.model.Usuario;

public class UsuarioRequest {

    private String nome;
    private String email;
    private String cpf;
    private String numeroCelular;

    @Deprecated
    public UsuarioRequest(){}

    public UsuarioRequest(String nome,String email,String cpf,String numeroCelular) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
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

    public Usuario toModel(){
        return new Usuario(this.nome, this.email,this.cpf,this.numeroCelular);
    }


}
