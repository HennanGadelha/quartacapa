package com.quartacapa.anuncios.repository;

import com.quartacapa.anuncios.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, String> {
}
