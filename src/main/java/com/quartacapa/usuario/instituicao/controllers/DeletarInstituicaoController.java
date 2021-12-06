package com.quartacapa.usuario.instituicao.controllers;

import com.quartacapa.usuario.instituicao.InstituicaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
@Api(tags = "Instituições")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
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
