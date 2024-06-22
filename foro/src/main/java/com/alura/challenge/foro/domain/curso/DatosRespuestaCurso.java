package com.alura.challenge.foro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosRespuestaCurso(
        @NotNull
        Long id,
        String nombre,
        Categoria categoria
) {
}
