package com.alura.challenge.foro.domain.usuario;

import com.alura.challenge.foro.domain.perfil.Perfil;

import java.util.Set;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String email,
        String password,
        Set<Perfil> perfiles
) {
}
