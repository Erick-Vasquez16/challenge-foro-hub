package com.alura.challenge.foro.domain.perfil;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroPerfil(
        @NotNull
        String nombre
) {
}
