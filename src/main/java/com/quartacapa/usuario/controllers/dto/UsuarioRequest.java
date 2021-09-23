package com.quartacapa.usuario.controllers.dto;

import com.quartacapa.config.validacoes.uniqueValue.UniqueValue;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.usuario.model.Usuario;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioRequest {
    @NotNull @NotBlank @NotEmpty
    private String nome;
    @Email @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Usuario.class, fieldName = "email")
    private String email;
    @CPF @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Usuario.class, fieldName = "cpf")
    private String cpf;
    @NotNull @NotBlank @NotEmpty
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
