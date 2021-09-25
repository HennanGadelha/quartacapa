package com.quartacapa.livro.controllers;

import com.quartacapa.livro.repository.LivroRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/livros"))
public class DeletarLivro {

    @Autowired
    private LivroRepository repository;


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable String id){

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
