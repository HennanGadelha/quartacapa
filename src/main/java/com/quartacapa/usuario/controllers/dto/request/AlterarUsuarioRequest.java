package com.quartacapa.usuario.controllers.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlterarUsuarioRequest {


    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;
    @NotNull @NotBlank @NotEmpty
    private String numeroCelular;

    @Deprecated
    public AlterarUsuarioRequest(){}

    public AlterarUsuarioRequest(String nome, String email, String numeroCelular) {
        this.nome = nome;
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }
}
