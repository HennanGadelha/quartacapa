package com.quartacapa.livro.controllers.dto;

import com.quartacapa.livro.model.AnoEscolarEnum;

import java.math.BigDecimal;

public class LivroResponse {

    private String id;
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private BigDecimal valor;
    private String descricaoEstado;
    private Boolean disponivelParaDoacao;
    private String disciplina;

    private AnoEscolarEnum anoEscolar;

    @Deprecated
    LivroResponse(){}

    public LivroResponse(String id,
                         String isbn,
                         String titulo,
                         String autor,
                         String editora,
                         Integer ano,
                         BigDecimal valor,
                         String descricaoEstado,
                         Boolean disponivelParaDoacao,
                         AnoEscolarEnum anoEscolar,
                         String disciplina) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstado = descricaoEstado;
        this.disponivelParaDoacao = disponivelParaDoacao;
        this.anoEscolar = anoEscolar;
        this.disciplina = disciplina;
    }


    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() { return autor; }

    public String getEditora() {
        return editora;
    }

    public Integer getAno() { return ano; }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public Boolean getDisponivelParaDoacao() {
        return disponivelParaDoacao;
    }

    public AnoEscolarEnum getAnoEscolar() {
        return anoEscolar;
    }

    public String getDisciplina() {
        return disciplina;
    }
}
