package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/anuncios"))
public class DeletarAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAnuncio(@PathVariable String id){

        anuncioRepository.deleteById(id);

        return ResponseEntity.ok().build();

    }


}
