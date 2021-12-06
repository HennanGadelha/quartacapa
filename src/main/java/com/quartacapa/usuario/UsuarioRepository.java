package com.quartacapa.usuario;

import com.quartacapa.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>
{



}
