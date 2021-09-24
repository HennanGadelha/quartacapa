package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.controller.dto.request.CadastroAnuncioRequest;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@CrossOrigin(origins = "http://localhost:4200")
public class CadastroAnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;


    @PostMapping
    public ResponseEntity<?> cadastroAnuncio(@RequestBody CadastroAnuncioRequest request ){


        Optional<Livro> possiveLivro = livroRepository.findById(request.getIdLivro());
        Livro livro = possiveLivro.get();

        Optional<Usuario> possivelUsuario = usuarioRepository.findById(request.getIdUsuario());
        Usuario usuario = possivelUsuario.get();

        System.out.println("usuario" + possivelUsuario.get().getNome());


        System.out.println("livro" + possiveLivro.get().getTitulo());

        Anuncio anuncio = request.toModel(livro, usuario);

        anuncioRepository.save(anuncio);

        usuario.addAnuncio(anuncio);

        usuario.getAnuncios();

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


}
