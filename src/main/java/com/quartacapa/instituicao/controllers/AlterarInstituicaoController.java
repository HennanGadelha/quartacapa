package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoRequest;
import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
@Api(tags = "Instituições")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app/")
public class AlterarInstituicaoController {


    @Autowired
    private InstituicaoRepository repository;


    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza o cadastro de uma Instituição já existente cujo id foi especificado")
    public ResponseEntity<InstituicaoResponse> alterarInstituicao
            (@PathVariable String id, @RequestBody @Valid InstituicaoRequest request) {

        Optional<Instituicao> possivelInstituicao = repository.findById(id);

        Instituicao instituicao = possivelInstituicao.get();

        updateData(instituicao, request);

        repository.save(instituicao);

        InstituicaoResponse response = new InstituicaoResponse(instituicao.getId(), instituicao.getNome());

        return ResponseEntity.ok().body(response);

    }

    public void updateData(Instituicao instituicaoAlterada, InstituicaoRequest request) {
        instituicaoAlterada.setNome(request.getNome());

    }


}
