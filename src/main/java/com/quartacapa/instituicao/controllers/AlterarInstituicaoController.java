package com.quartacapa.instituicao.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoRequest;
import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/instituicoes"))
public class AlterarInstituicaoController {


    @Autowired
    private InstituicaoRepository repository;


    @PutMapping("/{id}")
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
