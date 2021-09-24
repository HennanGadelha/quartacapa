package com.quartacapa.livro.controllers.dto;

import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.livro.model.AnoEscolarEnum;
import com.quartacapa.livro.model.Livro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class LivroRequest {

    private String isbn;
    @NotNull @NotEmpty @NotBlank
    private String titulo;
    @NotNull @NotEmpty @NotBlank
    private String autor;
    private String editora;
    private Integer ano;
    @NotNull @Positive
    private BigDecimal valor;
    @NotNull @NotEmpty @NotBlank
    private String descricaoEstado;
    @NotNull
    private Boolean disponivelParaDoacao;

    private String idDisciplina;


    private AnoEscolarEnum anoEscolar;

    @Deprecated
    public LivroRequest(){}

    public LivroRequest(String isbn,
                        String titulo,
                        String autor,
                        String editora,
                        Integer ano,
                        BigDecimal valor,
                        String descricaoEstado,
                        Boolean disponivelParaDoacao,
                        AnoEscolarEnum anoEscolar,
                        String idDisciplina) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstado = descricaoEstado;
        this.disponivelParaDoacao = disponivelParaDoacao;
        this.anoEscolar = anoEscolar;
        this.idDisciplina = idDisciplina;
    }

    public Livro toModel(Disciplina disciplina){
        return new Livro(this.isbn,
                this.titulo,
                this.autor,
                this.editora,
                this.ano,
                this.valor,
                this.descricaoEstado,
                this.disponivelParaDoacao,
                this.anoEscolar,
                disciplina);
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

    public AnoEscolarEnum getAnoEscolar() {
        return anoEscolar;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }
}
