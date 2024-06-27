package com.alura.challenge.foro.domain.usuario;

import com.alura.challenge.foro.domain.perfil.Perfil;

import java.util.Set;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String email,
        String password,
        Set<Perfil> perfiles
) {
    public DatosListadoUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getPerfiles()
        );
    }
}
