package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.request.AnuncioLivroRequest;
import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/anuncios"))
@CrossOrigin(origins = "http://localhost:4200")
public class CadastroLivroAnuncioController {


    @Autowired
    LivroRepository livroRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    AnuncioRepository anuncioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> cadastroAnuncio(@RequestBody AnuncioLivroRequest request ){


        Optional<Disciplina> possivelDisciplina = disciplinaRepository.findById(request.getIdDisciplina());
        Disciplina disciplina = possivelDisciplina.get();

        Livro livro = request.toLivro(disciplina);

        livroRepository.save(livro);

        Optional<Usuario> possivelUsuario = usuarioRepository.findById(request.getIdUsuario());

        Usuario usuario = possivelUsuario.get();

        Anuncio anuncio = request.toAnuncio(livro, usuario);

        anuncioRepository.save(anuncio);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(anuncio.getId()).toUri();

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


        return ResponseEntity.created(uri).body(response);

    }


}
