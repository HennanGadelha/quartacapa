package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
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
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app/")
public class ListarTodasDisciplinasController {

    @Autowired
    private DisciplinaRepository repository;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as Disciplinas cadastradas")
    public ResponseEntity<List<?>> listarTodas(){

        List<DisciplinaResponse> disciplinas = new ArrayList<>();

        repository.findAll()
                .stream().map(disciplina -> disciplinas
                .add(new DisciplinaResponse(disciplina.getId(), disciplina.getNome()))).toArray();


        return ResponseEntity.ok().body(disciplinas);

    }

}
