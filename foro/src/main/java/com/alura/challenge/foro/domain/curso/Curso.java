package com.alura.challenge.foro.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Curso")
@Table(name="cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(DatosRegistroCurso datosRegistroCurso){
        this.activo = true;
        this.nombre = datosRegistroCurso.nombre();
        this.categoria =datosRegistroCurso.categoria();
    }

    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso){
        if (datosActualizarCurso.nombre() != null){
            this.nombre = datosActualizarCurso.nombre();
        }
    }

    public void desactivarCurso() {
        this.activo = false;
    }
}

















