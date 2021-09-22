package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaRequest;
import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
public class CadastroDisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody DisciplinaRequest request){

        Disciplina disciplina = request.toModel();

        repository.save(disciplina);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(disciplina.getId()).toUri();

        DisciplinaResponse response = new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.created(uri).body(response);

    }

}
