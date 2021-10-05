package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
@Api(tags = "Instituições")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app/")
public class BuscarInstituicaoPorIdController {


    @Autowired
    private InstituicaoRepository repository;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna as informações de uma Instituição cujo id foi especificado")
    public ResponseEntity<InstituicaoResponse> buscarPorId(@PathVariable String id){

        Optional<Instituicao> possivelInstituicao = repository.findById(id);

        Instituicao instituicao = possivelInstituicao.get();

        InstituicaoResponse response =
                new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        return ResponseEntity.ok().body(response);

    }



}
