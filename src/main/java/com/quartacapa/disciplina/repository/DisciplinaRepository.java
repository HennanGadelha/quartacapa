package com.quartacapa.disciplina.repository;

import com.quartacapa.disciplina.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
}
