package com.alura.challenge.foro.domain.topico;

import com.alura.challenge.foro.domain.curso.Curso;
import com.alura.challenge.foro.domain.respuesta.Respuesta;
import com.alura.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        LocalDateTime fecha_creacion,
        Boolean status
) {
}
