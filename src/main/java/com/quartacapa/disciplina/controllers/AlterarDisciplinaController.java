package com.quartacapa.disciplina.controllers;

import com.quartacapa.disciplina.controllers.dto.DisciplinaRequest;
import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/disciplinas"))
@Api(tags = "Disciplinas")
@CrossOrigin(origins = "*")
public class AlterarDisciplinaController {

    @Autowired
    private DisciplinaRepository repository;


    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza o cadastro de uma Disciplina já existente cujo id foi especificado")
    public ResponseEntity<DisciplinaResponse> alterarDisciplina
            (@PathVariable String id, @RequestBody @Valid DisciplinaRequest request) {

        Optional<Disciplina> possivelDisciplina = repository.findById(id);

        Disciplina disciplina = possivelDisciplina.get();

        updateData(disciplina, request);

        repository.save(disciplina);

        DisciplinaResponse response = new DisciplinaResponse(disciplina.getId(), disciplina.getNome());

        return ResponseEntity.ok().body(response);

    }

    public void updateData(Disciplina disciplinaAlterada, DisciplinaRequest request) {
        disciplinaAlterada.setNome(request.getNome());

    }

}
