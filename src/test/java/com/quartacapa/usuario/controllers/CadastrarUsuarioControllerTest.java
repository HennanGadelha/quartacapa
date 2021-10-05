package com.quartacapa.usuario.controllers;

import com.quartacapa.anuncios.controller.CadastroLivroAnuncioController;
import com.quartacapa.usuario.controllers.dto.request.UsuarioRequest;
import com.quartacapa.usuario.controllers.dto.response.UsuarioResponse;
import com.quartacapa.usuario.model.Usuario;
import com.quartacapa.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(CadastrarUsuarioController.class)
class CadastrarUsuarioControllerTest {


    @Autowired
    private CadastrarUsuarioController target;

    @MockBean
    private UsuarioRepository repository;

    private UsuarioRequest usuarioRequest;
    private Usuario usuario;
    private ResponseEntity<UsuarioResponse> response;



    @BeforeEach
    public void setup(){


        usuarioRequest = new UsuarioRequest("nome teste", "emailteste@gmail.com", "50285280040", "8199999999");
        usuario = usuarioRequest.toModel();

    }


    @Test
    public void deveCadastrarUsuario(){

        target.cadastrarUsuario(usuarioRequest);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}