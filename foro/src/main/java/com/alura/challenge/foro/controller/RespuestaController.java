package com.alura.challenge.foro.controller;


import com.alura.challenge.foro.domain.respuesta.*;
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
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    RespuestasRepository repository;

    @PostMapping
    public ResponseEntity<DatosRespuestas> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta, UriComponentsBuilder uriComponentsBuilder){
        Respuesta respuesta = repository.save(new Respuesta(datosRegistroRespuesta));
        DatosRespuestas datosRespuestas = new DatosRespuestas(respuesta.getId(), respuesta.getMensaje(),respuesta.getFechaCreacion(),respuesta.getSolucion(),respuesta.getTopico(),respuesta.getUsuario());
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestas);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuesta>> listadoRespuesta(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(repository.findByStatusTrue(paginacion).map(DatosListadoRespuesta::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta){
        Respuesta respuesta = repository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarDatos(datosActualizarRespuesta);
        return ResponseEntity.ok(new DatosRespuestas(respuesta.getId(),respuesta.getMensaje(),respuesta.getFechaCreacion(),respuesta.getSolucion(),respuesta.getTopico(),respuesta.getUsuario()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id){
        Respuesta respuesta = repository.getReferenceById(id);
        respuesta.desactivarRespuesta();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestas> retornoDatosRespuesta(@PathVariable Long id){
        Respuesta respuesta = repository.getReferenceById(id);
        var datosRespuesta = new DatosRespuestas(respuesta.getId(),respuesta.getMensaje(),respuesta.getFechaCreacion(),respuesta.getSolucion(),respuesta.getTopico(),respuesta.getUsuario());
        respuesta.desactivarRespuesta();
        return ResponseEntity.ok(datosRespuesta);
    }
}
