package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.repository.InstituicaoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
@CrossOrigin(origins = "*")
public class DeletarInstituicaoController {

    @Autowired
    private InstituicaoRepository repository;


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma Instituição cujo id foi especificado")
    public ResponseEntity<?> deletarPorId(@PathVariable String id){

        repository.deleteById(id);

        return ResponseEntity.ok().build();

    }


}