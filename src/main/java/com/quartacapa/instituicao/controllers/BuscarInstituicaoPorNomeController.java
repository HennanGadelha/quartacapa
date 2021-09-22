package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class BuscarInstituicaoPorNomeController {


    @Autowired
    private InstituicaoRepository repository;

    @GetMapping("/filtro")
    public ResponseEntity<InstituicaoResponse> buscarPorNome(@RequestParam("nome") String nome){

        Optional<Instituicao> possivelInstituicao =  repository.findByNome(nome);

        Instituicao instituicao = possivelInstituicao.get();

        InstituicaoResponse response = new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        return ResponseEntity.ok().body(response);

    }

}
