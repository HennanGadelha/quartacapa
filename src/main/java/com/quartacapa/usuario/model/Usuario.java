package com.quartacapa.usuario.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCelular;
    
    @Deprecated
    public Usuario(){}

    public Usuario(String nome,String email,String cpf, String numeroCelular) {
        this.id = UUID.randomUUID().toString();
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
