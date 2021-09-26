package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@CrossOrigin(origins = "*")
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
