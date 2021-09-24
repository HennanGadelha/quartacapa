package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.request.AlterarAnuncioRequest;
import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
public class AlterarAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @PutMapping("/{id}")
    public ResponseEntity<AnuncioResponse> alterarAnuncio(@PathVariable String id, @RequestBody AlterarAnuncioRequest request){

        Optional<Anuncio> possivelAnuncio = anuncioRepository.findById(id);
        Anuncio anuncio = possivelAnuncio.get();

        updateData(anuncio, request);

        anuncioRepository.save(anuncio);

        AnuncioResponse response =
                new AnuncioResponse(
                        anuncio.getId(),
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


    public void updateData(Anuncio anuncioASerAlterado, AlterarAnuncioRequest request){

        anuncioASerAlterado.setTitulo(request.getTitulo());
        anuncioASerAlterado.setDescricao(request.getDescricao());
        anuncioASerAlterado.setFotoLivro(request.getFotoLivro());


    }


}
