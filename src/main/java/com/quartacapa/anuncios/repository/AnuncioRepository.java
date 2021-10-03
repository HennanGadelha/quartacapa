package com.quartacapa.anuncios.repository;

import com.quartacapa.anuncios.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnuncioRepository extends JpaRepository<Anuncio, String> {

    Optional<Anuncio> findByTitulo(String tituloDoAnuncio);
}
