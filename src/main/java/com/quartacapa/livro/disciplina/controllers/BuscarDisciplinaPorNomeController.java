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
