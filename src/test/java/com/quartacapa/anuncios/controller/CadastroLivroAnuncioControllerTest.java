package com.quartacapa.anuncios.controller;

import com.quartacapa.anuncios.controller.dto.request.AnuncioLivroRequest;
import com.quartacapa.anuncios.controller.dto.response.AnuncioResponse;
import com.quartacapa.anuncios.model.Anuncio;
import com.quartacapa.anuncios.model.AnuncioStatusEnum;
import com.quartacapa.anuncios.repository.AnuncioRepository;
import com.quartacapa.config.exceptions.EntidadeJaExistenteException;
import com.quartacapa.disciplina.controllers.CadastrarDisciplinaController;
import com.quartacapa.disciplina.controllers.dto.DisciplinaRequest;
import com.quartacapa.disciplina.model.Disciplina;
import com.quartacapa.disciplina.repository.DisciplinaRepository;
import com.quartacapa.livro.controllers.dto.LivroRequest;
import com.quartacapa.livro.model.AnoEscolarEnum;
import com.quartacapa.livro.model.Livro;
import com.quartacapa.livro.repository.LivroRepository;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CadastroLivroAnuncioController.class)
class CadastroLivroAnuncioControllerTest {

    @Autowired
    private CadastroLivroAnuncioController anuncioController;

    @Autowired
    private CadastrarDisciplinaController cadastrarDisciplinaController;

    @MockBean
    LivroRepository livroRepository;

    @MockBean
    DisciplinaRepository disciplinaRepository;

    @MockBean
    AnuncioRepository anuncioRepository;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    DisciplinaRepository repositoryDiscilina;


    private AnuncioLivroRequest requestAnuncio;
    private ResponseEntity<AnuncioResponse> responseAnuncio;
    private DisciplinaRequest disciplinaRequest;
    private Disciplina disciplina;
    Usuario usuario;
    private String id = UUID.randomUUID().toString();


    @BeforeEach
    public void setup(){


        disciplinaRequest = new DisciplinaRequest("matematica");

        cadastrarDisciplinaController.cadastrarDisciplina(disciplinaRequest);

        disciplina = disciplinaRequest.toModel();

        usuario = new Usuario("nome teste", "emailteste@gmail.com", "50285280040", "8199999999");

        requestAnuncio = new AnuncioLivroRequest("123456",
                "titulo do livro teste",
                "auto do livro teste",
                "editora do livro teste",
                2021,
                BigDecimal.valueOf(25.50),
                "Descricao de estado teste",
                true,
                disciplina.getId(),
                AnoEscolarEnum.NONO_ANO_FUNDAMMENTAL,
                "titulo do anucio teste",
                "descricao o anuncio teste",
                "link da foto teste",
                AnuncioStatusEnum.DISPONIVEL,
                usuario.getId()
                );




    }


    @Test
    public void deveCadastrarAnuncio() throws EntidadeJaExistenteException, Exception {


        responseAnuncio =  anuncioController.cadastroAnuncio(requestAnuncio);

        assertEquals(HttpStatus.CREATED, responseAnuncio.getStatusCode());


    }





}