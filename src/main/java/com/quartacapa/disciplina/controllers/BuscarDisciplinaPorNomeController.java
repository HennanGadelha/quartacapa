package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
public class BuscarDisciplinaPorNomeController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping("/filtro")
    public ResponseEntity<DisciplinaResponse> buscarPorNome(@RequestParam("nome") String nome){

        Optional<Disciplina> possivelDisciplina =  repository.findByNome(nome);

        Disciplina disciplina = possivelDisciplina.get();

        DisciplinaResponse response = new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.ok().body(response);

    }
}
