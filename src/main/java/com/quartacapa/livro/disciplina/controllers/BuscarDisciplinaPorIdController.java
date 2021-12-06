package com.quartacapa.livro.disciplina.controllers;

import com.quartacapa.livro.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.livro.disciplina.Disciplina;
import com.quartacapa.livro.disciplina.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class BuscarDisciplinaPorIdController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna as informações de uma Disciplina cujo id foi especificado")
    public ResponseEntity<DisciplinaResponse> buscarPorId(@PathVariable String id){

        Optional<Disciplina> possivelDisciplina = repository.findById(id);

        Disciplina disciplina = possivelDisciplina.get();

        DisciplinaResponse response =
                new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.ok().body(response);

    }
}
