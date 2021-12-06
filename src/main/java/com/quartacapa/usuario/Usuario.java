package com.quartacapa.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.usuario.instituicao.Instituicao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCelular;

    @OneToOne
    private Instituicao instituicao;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Anuncio> anuncios = new ArrayList<Anuncio>();

    @Deprecated
    public Usuario(){}

    public Usuario(String nome,String email,String cpf, String numeroCelular, Instituicao instituicao) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.instituicao = instituicao;
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

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void addAnuncio(Anuncio anuncio){
        this.anuncios.add(anuncio);
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
