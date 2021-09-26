package com.quartacapa.livro.controllers;

import com.quartacapa.livro.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/livros"))
@CrossOrigin(origins = "*")
public class DeletarLivroController {

    @Autowired
    private LivroRepository repository;


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Livro cujo id foi especificado")
    public ResponseEntity<?> deletarPorId(@PathVariable String id){

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
