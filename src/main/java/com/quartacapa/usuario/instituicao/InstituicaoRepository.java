package com.quartacapa.usuario.instituicao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituicaoRepository extends JpaRepository<Instituicao, String> {

    Optional<Instituicao> findByNome(String nome);

}
