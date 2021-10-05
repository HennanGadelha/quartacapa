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
public class BuscarInstituicaoPorNomeController {


    @Autowired
    private InstituicaoRepository repository;

    @GetMapping("/filtro")
    @ApiOperation(value = "Retorna as informações de uma Instituição cujo nome foi especificado")
    public ResponseEntity<InstituicaoResponse> buscarPorNome(@RequestParam("nome") String nome){

        Optional<Instituicao> possivelInstituicao =  repository.findByNome(nome);

        Instituicao instituicao = possivelInstituicao.get();

        InstituicaoResponse response = new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        return ResponseEntity.ok().body(response);

    }

}
