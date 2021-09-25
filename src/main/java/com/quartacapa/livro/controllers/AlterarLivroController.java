package com.quartacapa.livro.controllers;


import com.quartacapa.livro.controllers.dto.LivroRequest;
import com.quartacapa.livro.controllers.dto.LivroResponse;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/livros")
public class AlterarLivroController {


    @Autowired
    private LivroRepository repository;


    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> alterarLivro
            (@PathVariable String id, @RequestBody @Valid LivroRequest request) {

        Optional<Livro> possivelLivro = repository.findById(id);

        Livro livro = possivelLivro.get();

        updateData (livro, request);

        repository.save(livro);

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
                        livro.getAnoEscolar(),
                        livro.getDisciplina().getNome());

        return ResponseEntity.ok().body(response);

    }


    public void updateData(Livro livroAlterado, LivroRequest request){
        livroAlterado.setIsbn(request.getIsbn());
        livroAlterado.setTitulo(request.getTitulo());
        livroAlterado.setAutor(request.getAutor());
        livroAlterado.setEditora(request.getEditora());
        livroAlterado.setAno(request.getAno());
        livroAlterado.setValor(request.getValor());
        livroAlterado.setDescricaoEstado(request.getDescricaoEstado());
        livroAlterado.setDisponivelParaDoacao(request.getDisponivelParaDoacao());
    }

}
