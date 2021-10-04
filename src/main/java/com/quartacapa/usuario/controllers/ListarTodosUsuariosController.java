package com.quartacapa.usuario.controllers;

import com.quartacapa.usuario.controllers.dto.response.UsuarioResponse;
import com.quartacapa.usuario.repository.UsuarioRepository;
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
@RequestMapping(("/api/v1/usuarios"))
@Api(tags = "Usuários")
@CrossOrigin(origins = "*")
public class ListarTodosUsuariosController {

    @Autowired
    private UsuarioRepository repository;


    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os Usuários cadastrados")
    public ResponseEntity<List<?>> listarTodas(){

        List<UsuarioResponse> usuarios = new ArrayList<>();

        repository.findAll()
                .stream().map(usuario -> usuarios
                        .add(new UsuarioResponse(usuario.getId(), usuario.getNome() ,usuario.getEmail(),
                                usuario.getCpf(),usuario.getNumeroCelular(),usuario.getAnuncios()))).toArray();


        return ResponseEntity.ok().body(usuarios);

    }

}
