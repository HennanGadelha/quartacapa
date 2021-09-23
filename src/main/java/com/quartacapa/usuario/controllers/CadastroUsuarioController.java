package com.quartacapa.usuario.controllers;

import com.quartacapa.usuario.controllers.dto.UsuarioRequest;
import com.quartacapa.usuario.controllers.dto.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(("/api/v1/usuarios"))
public class CadastroUsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioRequest request){

        Usuario usuario = request.toModel();

        repository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        UsuarioResponse response = new UsuarioResponse(usuario.getId(), usuario.getNome() ,usuario.getEmail(),
                usuario.getCpf(),usuario.getNumeroCelular());

        return ResponseEntity.created(uri).body(response);

    }

}