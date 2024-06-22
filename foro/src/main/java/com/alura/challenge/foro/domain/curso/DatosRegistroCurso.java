package com.alura.challenge.foro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
) {
}
