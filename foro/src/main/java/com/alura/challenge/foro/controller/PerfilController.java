package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.domain.curso.*;
import com.alura.challenge.foro.domain.perfil.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilRespository perfilRespository;

    @PostMapping
    public ResponseEntity<DatosRespuestaPerfil> registrarPerfil(@RequestBody @Valid DatosRegistroPerfil datosRegistroPerfil, UriComponentsBuilder uriComponentsBuilder){
        Perfil perfil = perfilRespository.save(new Perfil(datosRegistroPerfil));
        DatosRespuestaPerfil datosRespuestaPerfil = new DatosRespuestaPerfil(perfil.getId(), perfil.getNombre());
        URI url = uriComponentsBuilder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaPerfil);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoPerfil>> listadoPerfil(@PageableDefault(size = 1) Pageable paginacion) {
        return ResponseEntity.ok(perfilRespository.findByStatusTrue(paginacion).map(DatosListadoPerfil::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarPerfil(@RequestBody @Valid DatosActualizarPerfil datosActualizarPerfil){
        Perfil perfil = perfilRespository.getReferenceById(datosActualizarPerfil.id());
        perfil.actualizarDatos(datosActualizarPerfil);
        return ResponseEntity.ok(new DatosRespuestaPerfil(perfil.getId(), perfil.getNombre()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarPerfil(@PathVariable Long id){
        Perfil perfil = perfilRespository.getReferenceById(id);
        perfil.desactivarPerfil();
        return ResponseEntity.noContent().build();
    }

    //para que muestre los datos despue insertar
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaPerfil> retornoDatosPerfil(@PathVariable Long id){
        Perfil perfil = perfilRespository.getReferenceById(id);
        var datosPerfil = new DatosRespuestaPerfil(perfil.getId(), perfil.getNombre());
        perfil.desactivarPerfil();
        return ResponseEntity.ok(datosPerfil);
    }
}
