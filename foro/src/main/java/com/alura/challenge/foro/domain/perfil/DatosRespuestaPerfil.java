package com.alura.challenge.foro.domain.perfil;

import jakarta.validation.constraints.NotNull;

public record DatosRespuestaPerfil(
        @NotNull
        Long id,
        String nombre
) {
}
