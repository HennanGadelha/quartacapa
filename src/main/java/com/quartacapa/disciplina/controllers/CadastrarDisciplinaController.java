package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaRequest;
import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "*")
public class CadastrarDisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    @ApiOperation(value = "Salva o cadastro inicial de uma nova Disciplina")
    public ResponseEntity<?> cadastrarDisciplina(@RequestBody @Valid DisciplinaRequest request){

        Disciplina disciplina = request.toModel();

        repository.save(disciplina);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(disciplina.getId()).toUri();

        DisciplinaResponse response = new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.created(uri).body(response);

    }

}
