package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.request.AlterarStatusAnuncioRequest;
import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@Api(tags = "Anúncios")
@CrossOrigin(origins = "http://localhost:4200")
public class AlterarStatusAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;


    @PutMapping("/alterarstatus/{id}")
    @ApiOperation(value = "Atualiza o status de um Anúncio já existente cujo id foi especificado")
    public ResponseEntity<AnuncioResponse> alterarStatusAnuncio(@PathVariable String id, @RequestBody @Valid AlterarStatusAnuncioRequest request){

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
                        anuncio.getLivro().getDescricaoEstado().toString(),
                        anuncio.getLivro().getDisponivelParaDoacao(),
                        anuncio.getLivro().getDisciplina().getNome(),
                        anuncio.getUsuario().getNome(),
                        anuncio.getUsuario().getEmail(),
                        anuncio.getUsuario().getNumeroCelular(),
                        anuncio.getAnuncioStatus().toString());


        return ResponseEntity.ok().body(response);



    }


    public void updateData(Anuncio anuncioASerAlterado, AlterarStatusAnuncioRequest request){

        anuncioASerAlterado.setAnuncioStatus(request.getAnuncioStatusEnum());

    }


}
