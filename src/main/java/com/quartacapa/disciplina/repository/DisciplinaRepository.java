package com.quartacapa.disciplina.repository;

import com.quartacapa.disciplina.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {

    Optional<Disciplina> findByNome(String nome);
}
