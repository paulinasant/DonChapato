package com.daw.DonChapato.repository;

import com.daw.DonChapato.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}