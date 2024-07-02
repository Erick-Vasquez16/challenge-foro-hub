package com.alura.challenge.foro.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByStatusTrue(Pageable paginacion);
}
