package com.quartacapa.livro.model;

import com.quartacapa.disciplina.model.Disciplina;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    //private Disciplina disciplina;
    //private Usuario usuario; ??????????
    //private Enum classe;

    @Deprecated
    public Livro(){}

    public Livro(String isbn, String titulo, String autor, String editora, Integer ano, BigDecimal valor, String descricaoEstado, Boolean disponivelParaDoacao) {

        this.id = UUID.randomUUID().toString();
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstado = descricaoEstado;
        this.disponivelParaDoacao = disponivelParaDoacao;
        //this.disciplina = disciplina;
        //this.classe = classe;
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

//    public Disciplina getDisciplina() {
//        return disciplina;
//    }
//
//    public void setDisciplina(Disciplina disciplina) {
//        this.disciplina = disciplina;
//    }
//
//    public Enum getClasse() {
//        return classe;
//    }
//
//    public void setClasse(Enum classe) {
//        this.classe = classe;
//    }
}