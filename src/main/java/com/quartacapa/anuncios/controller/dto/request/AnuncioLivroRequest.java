package com.quartacapa.anuncios.controller.dto.request;

import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.model.AnuncioStatusEnum;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.livro.model.AnoEscolarEnum;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.usuario.model.Usuario;


import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AnuncioLivroRequest {
    private String isbn;
    @NotNull @NotEmpty @NotBlank
    private String titulo;
    @NotNull @NotEmpty @NotBlank
    private String autor;
    private String editora;
    @NotNull @Positive @Digits(integer = 4, fraction = 0)
    private Integer ano;
    @NotNull @Min(0) @Digits(integer = 3, fraction = 2)
    private BigDecimal valor;
    @NotNull @NotEmpty @NotBlank
    private String descricaoEstado;
    @NotNull
    private Boolean disponivelParaDoacao;
    private String idDisciplina;
    private AnoEscolarEnum anoEscolar;


    //dados do anuncio
    @NotNull @NotEmpty @NotBlank
    private String tituloDoAnuncio;
    @NotNull @NotEmpty @NotBlank
    private String descricao;
    private String fotoLivro;
    private AnuncioStatusEnum anuncioStatus;
    private String idUsuario;


    public Livro toLivro(Disciplina disciplina){
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

    public Anuncio toAnuncio(Livro livro, Usuario usuario){
        return new Anuncio(this.tituloDoAnuncio,
                this.descricao,
                livro,
                usuario,
                this.fotoLivro,
                this.anuncioStatus);
    }

    @Deprecated
    public AnuncioLivroRequest(){}

    public AnuncioLivroRequest(String isbn,
                               String titulo,
                               String autor,
                               String editora,
                               Integer ano,
                               BigDecimal valor,
                               String descricaoEstado,
                               Boolean disponivelParaDoacao,
                               String idDisciplina,
                               AnoEscolarEnum anoEscolar,
                               String tituloDoAnuncio,
                               String descricao,
                               String fotoLivro,
                               AnuncioStatusEnum anuncioStatus,
                               String idUsuario) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.valor = valor;
        this.descricaoEstado = descricaoEstado;
        this.disponivelParaDoacao = disponivelParaDoacao;
        this.idDisciplina = idDisciplina;
        this.anoEscolar = anoEscolar;
        this.tituloDoAnuncio = tituloDoAnuncio;
        this.descricao = descricao;
        this.fotoLivro = fotoLivro;
        this.anuncioStatus = anuncioStatus;
        this.idUsuario = idUsuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
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

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public AnoEscolarEnum getAnoEscolar() {
        return anoEscolar;
    }


    public String getTituloDoAnuncio() {
        return tituloDoAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFotoLivro() {
        return fotoLivro;
    }

    public AnuncioStatusEnum getAnuncioStatus() {return anuncioStatus; }

    public String getIdUsuario() {
        return idUsuario;
    }
}
