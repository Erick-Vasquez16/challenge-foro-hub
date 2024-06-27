package com.alura.challenge.foro.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRespository {
    Page<Usuario> findByActivoTrue(Pageable paginacion);
}
