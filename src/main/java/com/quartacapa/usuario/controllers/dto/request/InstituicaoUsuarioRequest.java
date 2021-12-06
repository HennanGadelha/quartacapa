package com.quartacapa.usuario.controllers.dto.request;

import com.quartacapa.config.validacoes.uniqueValue.UniqueValue;
import com.quartacapa.usuario.instituicao.Instituicao;
import com.quartacapa.usuario.Usuario;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InstituicaoUsuarioRequest {

    @NotNull
    @NotBlank
    @NotEmpty
    private String nomeDaInstituicao;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nomeDoVendedor;
    @Email
    @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Usuario.class, fieldName = "email")
    private String email;
    @CPF
    @NotNull @NotBlank @NotEmpty @UniqueValue(domainClass = Usuario.class, fieldName = "cpf")
    private String cpf;
    @NotNull @NotBlank @NotEmpty
    private String numeroCelular;


    public InstituicaoUsuarioRequest(String nomeDaInstituicao, String nomeDoVendedor, String email, String cpf, String numeroCelular) {
        this.nomeDaInstituicao = nomeDaInstituicao;
        this.nomeDoVendedor = nomeDoVendedor;
        this.email = email;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
    }

    public Instituicao toInstituicao(){
        return new Instituicao(this.nomeDaInstituicao);
    }

    public Usuario toModel(){
        return new Usuario(this.nomeDoVendedor, this.email,this.cpf,this.numeroCelular);
    }

    public String getNomeDaInstituicao() {
        return nomeDaInstituicao;
    }

    public String getNomeDoVendedor() {
        return nomeDoVendedor;
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

    public void setNomeDaInstituicao(String nomeDaInstituicao) {
        this.nomeDaInstituicao = nomeDaInstituicao;
    }

    public void setNomeDoVendedor(String nomeDoVendedor) {
        this.nomeDoVendedor = nomeDoVendedor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
