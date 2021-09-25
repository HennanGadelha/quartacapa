package com.quartacapa.livro.repository;

import com.quartacapa.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, String> {

    Optional<Livro> findByTitulo(String titulo);
}
