package com.quartacapa.usuario.controllers;
import com.quartacapa.usuario.controllers.dto.response.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(("/api/v1/usuarios"))
@Api(tags = "Usuários")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class BuscarUsuarioPorIdController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna as informações de um Usuário cujo id foi especificado")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable String id){

        Optional<Usuario> possivelUsuario = repository.findById(id);

        Usuario usuario = possivelUsuario.get();

        UsuarioResponse response =
                new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(),
                        usuario.getNumeroCelular(), usuario.getAnuncios());

        return ResponseEntity.ok().body(response);

    }
}
