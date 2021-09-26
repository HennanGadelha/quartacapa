package com.quartacapa.livro.controllers;

import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import com.quartacapa.livro.controllers.dto.LivroRequest;
import com.quartacapa.livro.controllers.dto.LivroResponse;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/livros"))
public class CadastrarLivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroRequest request){


        Optional<Disciplina> possivelDisciplina = disciplinaRepository.findById(request.getIdDisciplina());

        Disciplina disciplina = possivelDisciplina.get();


        Livro livro = request.toModel(disciplina);

        repository.save(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livro.getId()).toUri();

        LivroResponse response =
                new LivroResponse(livro.getId(),
                        livro.getIsbn(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getEditora(),
                        livro.getAno(),
                        livro.getValor(),
                        livro.getDescricaoEstado(),
                        livro.getDisponivelParaDoacao(),
                        /*livro.getAnoEscolar(),*/
                        livro.getDisciplina().getNome());

        return ResponseEntity.created(uri).body(response);

    }
}
