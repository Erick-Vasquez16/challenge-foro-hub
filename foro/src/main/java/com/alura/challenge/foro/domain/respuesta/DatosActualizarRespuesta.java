package com.alura.challenge.foro.domain.respuesta;

import com.alura.challenge.foro.domain.topico.Topico;
import com.alura.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarRespuesta(
        @NotNull
        Long id,
        String mensaje,
        Boolean solucion,
        Topico topico
) {
}
