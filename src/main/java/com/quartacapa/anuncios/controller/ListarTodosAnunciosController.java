package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@Api(tags = "Anúncios")
@CrossOrigin(origins = "https://quarta-capa-gdnvduz1v-jully-nixon.vercel.app")
public class ListarTodosAnunciosController {


    @Autowired
    private AnuncioRepository anuncioRepository;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os Anúncios cadastrados")
    public ResponseEntity<List<?>> listarTodosAnuncios() {

        List<Anuncio> anuncios = anuncioRepository.findAll();

        List<AnuncioResponse> response = new ArrayList<AnuncioResponse>();

        anuncioRepository.findAll().stream().map(anuncio -> response.add(
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
                        anuncio.getAnuncioStatus().toString()))).toArray();


        return ResponseEntity.ok().body(response);

    }


}
