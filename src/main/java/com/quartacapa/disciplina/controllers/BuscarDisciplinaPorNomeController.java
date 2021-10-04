package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "http://localhost:4200")
public class BuscarDisciplinaPorNomeController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping("/filtro")
    @ApiOperation(value = "Retorna as informações de uma Disciplina cujo nome foi especificado")
    public ResponseEntity<DisciplinaResponse> buscarPorNome(@RequestParam("nome") String nome){

        Optional<Disciplina> possivelDisciplina =  repository.findByNome(nome);

        Disciplina disciplina = possivelDisciplina.get();

        DisciplinaResponse response = new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.ok().body(response);

    }
}
