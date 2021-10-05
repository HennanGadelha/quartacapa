package com.quartacapa.livro.controllers;

import com.quartacapa.instituicao.controllers.dto.InstituicaoResponse;
import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import com.quartacapa.livro.controllers.dto.LivroResponse;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/livros"))
@Api(tags = "Livros")
@CrossOrigin(origins = "*")
public class BuscarLivroPorTituloController {

    @Autowired
    private LivroRepository repository;

    @GetMapping("/filtro")
    @ApiOperation(value = "Retorna as informações de um Livro cujo título foi especificado")
    public ResponseEntity<LivroResponse> buscarPorTitulo(@RequestParam("titulo") String titulo){

        Optional<Livro> possivelLivro =  repository.findByTitulo(titulo);

        Livro livro = possivelLivro.get();

        LivroResponse response = new LivroResponse(livro.getId(),
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
