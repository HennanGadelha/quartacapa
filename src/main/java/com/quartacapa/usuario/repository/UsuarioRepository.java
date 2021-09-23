package com.quartacapa.usuario.repository;

import com.quartacapa.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>
{



}
