package com.quartacapa.anuncios.controller;


import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
public class BuscarAnuncioPorIdController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @GetMapping("/{id}")
    public ResponseEntity<AnuncioResponse> buscarAnuncioPorId(@PathVariable String id){

        Optional<Anuncio> possivelAnuncio = anuncioRepository.findById(id);

        Anuncio anuncio = possivelAnuncio.get();

        AnuncioResponse response =
                new AnuncioResponse(anuncio.getId(),
                        anuncio.getTitulo(),
                        anuncio.getDescricao(),
                        anuncio.getFotoLivro(),
                        anuncio.getLivro().getIsbn(),
                        anuncio.getLivro().getTitulo(),
                        anuncio.getLivro().getAutor(),
                        anuncio.getLivro().getEditora(),
                        anuncio.getLivro().getAno(),
                        anuncio.getLivro().getValor(),
                        anuncio.getLivro().getDescricaoEstado(),
                        anuncio.getLivro().getDisponivelParaDoacao(),
                        anuncio.getLivro().getDisciplina().getNome(),
                        anuncio.getUsuario().getNome(),
                        anuncio.getUsuario().getEmail(),
                        anuncio.getUsuario().getNumeroCelular());

        return ResponseEntity.ok().body(response);

    }


}
