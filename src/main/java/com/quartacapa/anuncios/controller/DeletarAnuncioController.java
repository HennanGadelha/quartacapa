package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.repository.AnuncioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@Api(tags = "Anúncios")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class DeletarAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Anúncio cujo id foi especificado")
    public ResponseEntity<?> deletarAnuncio(@PathVariable String id){

        anuncioRepository.deleteById(id);

        return ResponseEntity.ok().build();

    }


}
