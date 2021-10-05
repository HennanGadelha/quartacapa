package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import com.quartacapa.disciplina.controllers.dto.DisciplinaResponse;
import com.quartacapa.disciplina.model.Disciplina;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@Api(tags = "Anúncios")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class BuscarAnuncioPorTituloDoAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @GetMapping("/filtro")
    @ApiOperation(value = "Retorna as informações de um Anúncio cujo titúlo do anúncio foi especificado")
    public ResponseEntity<AnuncioResponse> buscarPorTituloAnuncio(@RequestParam("tituloDoAnuncio") String tituloDoAnuncio){

        Optional<Anuncio> possivelAnuncio =  anuncioRepository.findByTitulo(tituloDoAnuncio);

        Anuncio anuncio = possivelAnuncio.get();

        AnuncioResponse response =
                new AnuncioResponse(anuncio.getId(),
                        anuncio.getTitulo(),
                        anuncio.getLivro().getAnoEscolar().toString(),
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
                        anuncio.getUsuario().getNumeroCelular(),
                        anuncio.getAnuncioStatus().toString());

        return ResponseEntity.ok().body(response);

    }


}
