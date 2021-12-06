package com.quartacapa.anuncios.controller.dto.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class AnuncioResponse {

    private String idDoAnuncio;

    private String titulo;
    private String descricao;
    private String fotoLivro;

    private String isbn;
    private String tituloDoLivro;
    private String autor;
    private String editora;
    private Integer ano;
    private BigDecimal valor;
    private String descricaoEstadoDoLivro;
    private Boolean disponivelParaDoacao;
    private String disciplina;

    private String nome;
    private String email;
    private String numeroCelular;

    @Enumerated(EnumType.STRING)
    private String anuncioStatus;

    @Enumerated(EnumType.STRING)
    private String anoEscolar;



    @Deprecated
    public AnuncioResponse(){}

    public AnuncioResponse(String idDoAnuncio,
                           String titulo,
                           String anoEscolar,
                           String descricao,
                           String fotoLivro,
                           String isbn,
                           String tituloDoLivro,
                           String autor,
                           String editora,
                           Integer ano,
                           BigDecimal valor,
                           String descricaoEstadoDoLivro,
                           Boolean disponivelParaDoacao,
                           String disciplina,
                           String nome,
                           String email,
                           String numeroCelular,
                           String anuncioStatus) {


        this.idDoAnuncio = idDoAnuncio;
        this.titulo = titulo;
        this.anoEscolar = anoEscolar;
        this.descricao = descricao;
        this.fotoLivro = fotoLivro;
        this.isbn = isbn;
        this.tituloDoLivro = tituloDoLivro;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstadoDoLivro = descricaoEstadoDoLivro;
        this.disponivelParaDoacao = disponivelParaDoacao;
        this.disciplina = disciplina;
        this.nome = nome;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.anuncioStatus = anuncioStatus;

    }

    public String getIdDoAnuncio() {
        return idDoAnuncio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnoEscolar() { return anoEscolar; }

    public String getDescricao() {
        return descricao;
    }

    public String getFotoLivro() {
        return fotoLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public Integer getAno() {
        return ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricaoEstadoDoLivro() {
        return descricaoEstadoDoLivro;
    }

    public Boolean getDisponivelParaDoacao() {
        return disponivelParaDoacao;
    }

    public String getDisciplina() {
        return disciplina;
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

    public String getAnuncioStatus() { return anuncioStatus; }

}
