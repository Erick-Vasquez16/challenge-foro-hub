package com.alura.challenge.foro.domain.topico;

import com.alura.challenge.foro.domain.curso.Curso;
import com.alura.challenge.foro.domain.respuesta.Respuesta;
import com.alura.challenge.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Boolean status,
        Usuario usuario,
        Curso curso,
        List<Respuesta> respuestas
) {
    public DatosListadoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus(),
                topico.getUsuario(),
                topico.getCurso(),
                topico.getRespuestas()
        );
    }
}
