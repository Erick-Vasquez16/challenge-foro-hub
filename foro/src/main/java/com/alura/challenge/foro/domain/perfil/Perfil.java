package com.alura.challenge.foro.domain.perfil;

import com.alura.challenge.foro.domain.curso.DatosActualizarCurso;
import com.alura.challenge.foro.domain.curso.DatosRegistroCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Perfil")
@Table(name="perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo;

    public Perfil(DatosRegistroPerfil datosRegistroPerfil){
        this.activo = true;
        this.nombre = datosRegistroPerfil.nombre();
    }

    public void actualizarDatos(DatosActualizarPerfil datosActualizarPerfil){
        if (datosActualizarPerfil.nombre() != null){
            this.nombre = datosActualizarPerfil.nombre();
        }
    }

    public void desactivarPerfil() {
        this.activo = false;
    }
}
