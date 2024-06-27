package com.alura.challenge.foro.domain.usuario;

import com.alura.challenge.foro.domain.perfil.Perfil;

import java.util.Set;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String password,
        Set<Perfil> perfiles
) {
}
