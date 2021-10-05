package com.quartacapa.usuario.controllers;

import com.quartacapa.usuario.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/usuarios"))
@Api(tags = "Usuários")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class DeletarUsuarioController {

    @Autowired
    private UsuarioRepository repository;


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Usuário cujo id foi especificado")
    public ResponseEntity<?> deletarPorId(@PathVariable String id){

        repository.deleteById(id);

        return ResponseEntity.ok().build();

    }
}