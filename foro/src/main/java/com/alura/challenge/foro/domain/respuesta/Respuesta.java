package com.alura.challenge.foro.domain.respuesta;

import com.alura.challenge.foro.domain.perfil.DatosActualizarPerfil;
import com.alura.challenge.foro.domain.perfil.DatosRegistroPerfil;
import com.alura.challenge.foro.domain.topico.Topico;
import com.alura.challenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Respuesta")
@Table(name="respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private boolean activo;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta){
        this.activo = true;
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fechaCreacion = datosRegistroRespuesta.fechaCreacion();
        this.solucion = datosRegistroRespuesta.solucion();
        this.topico = datosRegistroRespuesta.topico();
        this.autor = datosRegistroRespuesta.autor();
    }
    public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta){
        if (datosActualizarRespuesta.mensaje() != null){
            this.mensaje = datosActualizarRespuesta.mensaje();
            this.fechaCreacion = datosActualizarRespuesta.fechaCreacion();
            this.solucion = datosActualizarRespuesta.solucion();
            this.topico = datosActualizarRespuesta.topico();
            this.autor = datosActualizarRespuesta.autor();
        }
    }
    public void desactivarRespuesta() {
        this.activo = false;
    }
}
