package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class ListarTodasInstituicoesController {

    @Autowired
    private InstituicaoRepository repository;


    @GetMapping
    public ResponseEntity<List<?>> listarTodas(){

        List<InstituicaoResponse> instituicoes = new ArrayList<>();

        repository.findAll()
                .stream().map(instituicao -> instituicoes
                .add(new InstituicaoResponse(instituicao.getId(), instituicao.getNome()))).toArray();


        return ResponseEntity.ok().body(instituicoes);

    }




}
