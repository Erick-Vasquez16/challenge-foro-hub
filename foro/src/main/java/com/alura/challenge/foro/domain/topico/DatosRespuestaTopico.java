package com.alura.challenge.foro.domain.topico;

import com.alura.challenge.foro.domain.curso.Curso;
import com.alura.challenge.foro.domain.respuesta.Respuesta;
import com.alura.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        Usuario autor,
        Curso curso,
        List<Respuesta> respuestas
) {
}
