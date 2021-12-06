package com.quartacapa.livro.disciplina;

import com.quartacapa.livro.Livro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Disciplina {

    @Id
    private String id;
    private String nome;

    @OneToMany(mappedBy="disciplina")
    private List<Livro> livros = new ArrayList<Livro>();

    @Deprecated
    public Disciplina(){}

    public Disciplina(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
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
}
