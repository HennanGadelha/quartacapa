package com.quartacapa.usuario.controllers;
import com.quartacapa.usuario.controllers.dto.response.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/usuarios"))
public class BuscarUsuarioPorId {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable String id){

        Optional<Usuario> possivelUsuario = repository.findById(id);

        Usuario usuario = possivelUsuario.get();

        UsuarioResponse response =
                new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(),
                        usuario.getNumeroCelular());

        return ResponseEntity.ok().body(response);

    }
}
