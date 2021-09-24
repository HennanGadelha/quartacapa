package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/anuncios"))
public class ListarTodosAnunciosController {


    @Autowired
    private AnuncioRepository anuncioRepository;


    @GetMapping
    public ResponseEntity<List<?>> listarTodosAnuncios() {

        List<Anuncio> anuncios = anuncioRepository.findAll();

        List<AnuncioResponse> response = new ArrayList<AnuncioResponse>();

        anuncioRepository.findAll().stream().map(anuncio -> response.add(
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
                        anuncio.getUsuario().getNumeroCelular()))).toArray();


        return ResponseEntity.ok().body(response);

    }


}
