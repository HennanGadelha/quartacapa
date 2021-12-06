package com.quartacapa.livro.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {

    Optional<Disciplina> findByNome(String nome);
}
