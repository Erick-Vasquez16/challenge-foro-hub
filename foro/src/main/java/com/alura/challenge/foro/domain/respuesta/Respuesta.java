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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Boolean status;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta){
        this.status = true;
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fechaCreacion = datosRegistroRespuesta.fechaCreacion();
        this.solucion = datosRegistroRespuesta.solucion();
        this.topico = datosRegistroRespuesta.topico();
        this.usuario = datosRegistroRespuesta.usuario();
    }
    public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta){
        if (datosActualizarRespuesta.mensaje() != null){
            this.mensaje = datosActualizarRespuesta.mensaje();
            this.solucion = datosActualizarRespuesta.solucion();
            this.topico = datosActualizarRespuesta.topico();
        }
    }
    public void desactivarRespuesta() {
        this.status = false;
    }
}
