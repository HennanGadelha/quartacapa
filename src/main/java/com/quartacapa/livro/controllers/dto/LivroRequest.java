package com.quartacapa.livro.controllers.dto;

import com.quartacapa.livro.model.Livro;

import java.math.BigDecimal;

public class LivroRequest {

    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private BigDecimal valor;
    private String descricaoEstado;
    private Boolean disponivelParaDoacao;
    //private Disciplina disciplina;
    //private Usuario usuario; ??????????
    //private Enum classe;

    @Deprecated
    public LivroRequest(){}

    public LivroRequest(String isbn, String titulo, String autor, String editora, Integer ano, BigDecimal valor, String descricaoEstado, Boolean disponivelParaDoacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstado = descricaoEstado;
        this.disponivelParaDoacao = disponivelParaDoacao;
    }

    public Livro toModel(){
        return new Livro(this.isbn, this.titulo, this.autor, this.editora, this.ano, this.valor, this.descricaoEstado, this.disponivelParaDoacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
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

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public Boolean getDisponivelParaDoacao() {
        return disponivelParaDoacao;
    }

}
