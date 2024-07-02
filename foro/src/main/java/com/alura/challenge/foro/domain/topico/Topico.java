package com.alura.challenge.foro.domain.topico;

import com.alura.challenge.foro.domain.curso.Curso;
import com.alura.challenge.foro.domain.perfil.DatosActualizarPerfil;
import com.alura.challenge.foro.domain.respuesta.Respuesta;
import com.alura.challenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.status = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha_creacion = datosRegistroTopico.fecha_creacion();
        this.usuario = datosRegistroTopico.usuario();
        this.curso = datosRegistroTopico.curso();
        this.respuestas = datosRegistroTopico.respuestas();

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
            this.mensaje = datosActualizarTopico.mensaje();
            this.fecha_creacion = datosActualizarTopico.fecha_creacion();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
