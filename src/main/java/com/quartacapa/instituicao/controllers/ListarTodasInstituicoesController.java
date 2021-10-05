package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
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
@RequestMapping(("/api/v1/instituicoes"))
@Api(tags = "Instituições")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app/")
public class ListarTodasInstituicoesController {

    @Autowired
    private InstituicaoRepository repository;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as Instituições cadastradas")
    public ResponseEntity<List<?>> listarTodas(){

        List<InstituicaoResponse> instituicoes = new ArrayList<>();

        repository.findAll()
                .stream().map(instituicao -> instituicoes
                .add(new InstituicaoResponse(instituicao.getId(), instituicao.getNome()))).toArray();


        return ResponseEntity.ok().body(instituicoes);

    }




}
