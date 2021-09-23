package com.quartacapa.usuario.controllers;

import com.quartacapa.usuario.controllers.dto.UsuarioRequest;
import com.quartacapa.usuario.controllers.dto.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;

import com.quartacapa.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/usuarios"))
public class AlterarUsuarioController {

    @Autowired
    private UsuarioRepository repository;


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> alterarUsuario
            (@PathVariable String id, @RequestBody @Valid UsuarioRequest request) {

        Optional<Usuario> possivelUsuario = repository.findById(id);

        Usuario usuario = possivelUsuario.get();

        updateData(usuario, request);

        repository.save(usuario);

        UsuarioResponse response = new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getCpf(),usuario.getNumeroCelular());




        return ResponseEntity.ok().body(response);

    }

    public void updateData(Usuario usuarioAlterado, UsuarioRequest request) {
        usuarioAlterado.setNome(request.getNome());
        usuarioAlterado.setEmail(request.getEmail());
        usuarioAlterado.setCpf(request.getCpf());
        usuarioAlterado.setNumeroCelular(request.getNumeroCelular());
    }

}
