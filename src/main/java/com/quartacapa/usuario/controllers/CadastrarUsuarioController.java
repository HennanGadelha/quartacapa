package com.quartacapa.usuario.controllers;

import com.quartacapa.instituicao.model.Instituicao;
import com.quartacapa.instituicao.repository.InstituicaoRepository;
import com.quartacapa.usuario.controllers.dto.request.InstituicaoUsuarioRequest;
import com.quartacapa.usuario.controllers.dto.request.UsuarioRequest;
import com.quartacapa.usuario.controllers.dto.response.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(("/api/v1/usuarios"))
@Api(tags = "Usuários")
@CrossOrigin(origins = "https://quarta-capa.vercel.app/")
public class CadastrarUsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Transactional(readOnly = true)
    @PostMapping
    @ApiOperation(value = "Salva o cadastro inicial de um novo Livro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid InstituicaoUsuarioRequest request){

        Instituicao instituicao = request.toInstituicao();
        Usuario usuario = request.toModel();

        instituicaoRepository.save(instituicao);
        repository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        UsuarioResponse response = new UsuarioResponse(usuario.getId(), usuario.getNome() ,usuario.getEmail(),
                usuario.getCpf(),usuario.getNumeroCelular(), usuario.getAnuncios());

        return ResponseEntity.created(uri).body(response);
    }
}
