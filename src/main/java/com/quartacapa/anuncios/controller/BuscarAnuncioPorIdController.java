package com.quartacapa.anuncios.controller;


import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@CrossOrigin(origins = "*")
public class BuscarAnuncioPorIdController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna as informações de um Anúncio cujo id foi especificado")
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
