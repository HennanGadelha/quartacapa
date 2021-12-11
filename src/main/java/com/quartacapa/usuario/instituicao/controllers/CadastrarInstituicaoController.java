package com.quartacapa.usuario.instituicao.controllers;

import com.quartacapa.usuario.instituicao.controllers.dto.InstituicaoRequest;
import com.quartacapa.usuario.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.usuario.instituicao.Instituicao;
import com.quartacapa.usuario.instituicao.InstituicaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
@Api(tags = "Instituições")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class CadastrarInstituicaoController {

    @Autowired
    private InstituicaoRepository repository;

    @PostMapping
    @ApiOperation(value = "Salva o cadastro inicial de uma nova Instituição")
    public ResponseEntity<?> cadastrarInstituicao(@RequestBody @Valid InstituicaoRequest request){

        Instituicao instituicao = request.toModel();

        repository.save(instituicao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(instituicao.getId()).toUri();

        InstituicaoResponse response = new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        return ResponseEntity.created(uri).body(response);

    }


}