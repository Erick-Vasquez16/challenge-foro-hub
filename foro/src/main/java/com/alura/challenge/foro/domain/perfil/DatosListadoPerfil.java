package com.alura.challenge.foro.domain.perfil;

public record DatosListadoPerfil(
        Long id,
        String nombre
) {
   public DatosListadoPerfil(Perfil perfil){
       this(
         perfil.getId(),
         perfil.getNombre()
       );
   }
}
