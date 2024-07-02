package com.alura.challenge.foro.domain.perfil;

import com.alura.challenge.foro.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRespository extends JpaRepository<Perfil,Long> {
    Page<Perfil> findByStatusTrue(Pageable paginacion);

}
