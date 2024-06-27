package com.alura.challenge.foro.domain.usuario;

import com.alura.challenge.foro.domain.perfil.DatosActualizarPerfil;
import com.alura.challenge.foro.domain.perfil.DatosRegistroPerfil;
import com.alura.challenge.foro.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name="Usuario")
@Table(name="usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private Boolean status;

    @ManyToMany
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Perfil> perfiles;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario){
        this.status = true;
        this.nombre = datosRegistroUsuario.nombre();
        this.email = datosRegistroUsuario.email();
        this.password = datosRegistroUsuario.password();
        this.perfiles = datosRegistroUsuario.perfiles();
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario){
        if (datosActualizarUsuario.nombre() != null){
            this.nombre = datosActualizarUsuario.nombre();
            this.email = datosActualizarUsuario.email();
            this.password = datosActualizarUsuario.password();
        }
    }

    public void desactivarUsuario() {
        this.status = false;
    }
}
