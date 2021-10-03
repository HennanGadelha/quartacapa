package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.request.AlterarAnuncioRequest;
import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@CrossOrigin(origins = "http://localhost:4200")
public class AlterarAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um Anúncio já existente cujo id foi especificado")
    public ResponseEntity<AnuncioResponse> alterarAnuncio(@PathVariable String id, @RequestBody @Valid AlterarAnuncioRequest request){

        Optional<Anuncio> possivelAnuncio = anuncioRepository.findById(id);
        Anuncio anuncio = possivelAnuncio.get();

        updateData(anuncio, request);

        anuncioRepository.save(anuncio);

        AnuncioResponse response =
                new AnuncioResponse(
                        anuncio.getId(),
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


    public void updateData(Anuncio anuncioASerAlterado, AlterarAnuncioRequest request){

        anuncioASerAlterado.setTitulo(request.getTitulo());
        anuncioASerAlterado.setDescricao(request.getDescricao());
        anuncioASerAlterado.setFotoLivro(request.getFotoLivro());


    }


}
