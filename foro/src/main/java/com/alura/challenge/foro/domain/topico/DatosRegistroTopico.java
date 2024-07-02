package com.alura.challenge.foro.domain.topico;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistroTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        LocalDateTime fecha_creacion,
        String autor,
        Boolean status
) {
}
