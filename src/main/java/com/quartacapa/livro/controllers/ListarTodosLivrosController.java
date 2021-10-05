package com.quartacapa.livro.controllers;

import com.quartacapa.livro.controllers.dto.LivroResponse;
import com.quartacapa.livro.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/livros"))
@Api(tags = "Livros")
@CrossOrigin(origins = "http://localhost:4200")
public class ListarTodosLivrosController {

    @Autowired
    private LivroRepository repository;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os Livros cadastrados")
    public ResponseEntity<List<?>> listarTodos(){

        List<LivroResponse> livros = new ArrayList<>();

        repository.findAll()
                .stream().map(livro -> livros
                .add(new LivroResponse(livro.getId(), livro.getIsbn(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAno(), livro.getValor(), livro.getDescricaoEstado().toString(), livro.getDisponivelParaDoacao(),livro.getAnoEscolar().toString() ,livro.getDisciplina().getNome())
                )).toArray();


        return ResponseEntity.ok().body(livros);
    }
}
