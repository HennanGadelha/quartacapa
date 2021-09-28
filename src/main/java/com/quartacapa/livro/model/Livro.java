package com.quartacapa.livro.model;

import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.disciplina.model.Disciplina;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Livro {

    @Id
    private String id;
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private BigDecimal valor;
    private String descricaoEstado;
    private Boolean disponivelParaDoacao;

    @OneToOne
    private Disciplina disciplina;


    @Enumerated(EnumType.STRING)
    private AnoEscolarEnum anoEscolar;

    @Deprecated
    public Livro(){}

    public Livro(String isbn,
                 String titulo,
                 String autor,
                 String editora,
                 Integer ano,
                 BigDecimal valor,
                 String descricaoEstado,
                 Boolean disponivelParaDoacao,
                 AnoEscolarEnum anoEscolar,
                 Disciplina disciplina) {

        this.id = UUID.randomUUID().toString();
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    public Boolean getDisponivelParaDoacao() {
        return disponivelParaDoacao;
    }

    public void setDisponivelParaDoacao(Boolean disponivelParaDoacao) {
        this.disponivelParaDoacao = disponivelParaDoacao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public AnoEscolarEnum getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(AnoEscolarEnum anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

}