package com.quartacapa.anuncios.model;

import com.quartacapa.livro.model.Livro;
import com.quartacapa.usuario.model.Usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Anuncio {

    @Id
    private String id;
    private LocalDate criadoEm;
    private String titulo;
    private String descricao;

    @OneToOne
    private Livro livro;

    @ManyToOne
    private Usuario usuario;

    private String fotoLivro;

    @Deprecated
    public Anuncio(){}

    public Anuncio(String titulo, String descricao, Livro livro, Usuario usuario, String fotoLivro) {

        this.id = UUID.randomUUID().toString();
        this.criadoEm = LocalDate.now();
        this.titulo = titulo;
        this.descricao = descricao;
        this.livro = livro;
        this.usuario = usuario;
        this.fotoLivro = fotoLivro;
    }

    public String getId() {
        return id;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFotoLivro() {
        return fotoLivro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFotoLivro(String fotoLivro) {
        this.fotoLivro = fotoLivro;
    }
}