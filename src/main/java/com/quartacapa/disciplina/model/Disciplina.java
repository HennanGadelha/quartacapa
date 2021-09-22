package com.quartacapa.disciplina.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Disciplina {

    @Id
    private String id;
    private String nome;

    // utilizou a @entity para mapear a classe
    // utilizou o @id para mapear o id
    // usar construtor vazio

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
