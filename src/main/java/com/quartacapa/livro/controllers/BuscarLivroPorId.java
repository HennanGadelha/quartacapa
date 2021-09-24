package com.quartacapa.livro.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import com.quartacapa.livro.controllers.dto.LivroResponse;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/livros"))
public class BuscarLivroPorId {

    @Autowired
    private LivroRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable String id){

        Optional<Livro> possivelLivro = repository.findById(id);

        Livro livro = possivelLivro.get();




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
                        livro.getAnoEscolar().toString(),
                        livro.getDisciplina().getNome());



        return ResponseEntity.ok().body(response);

    }

}
