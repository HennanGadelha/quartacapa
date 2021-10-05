package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app/")
public class DeletarDisciplinaController {

    @Autowired
    private DisciplinaRepository repository;


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma Disciplina cujo id foi especificado")
    public ResponseEntity<?> deletarPorId(@PathVariable String id){

        repository.deleteById(id);

        return ResponseEntity.ok().build();

    }
}
