package com.alura.challenge.foro.controller;

import com.alura.challenge.foro.domain.perfil.*;
import com.alura.challenge.foro.domain.usuario.*;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRespository respository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = respository.save(new Usuario(datosRegistroUsuario));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),usuario.getEmail(),usuario.getPassword(),usuario.getPerfiles());
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listadoUsuario(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(respository.findByStatusTrue(paginacion).map(DatosListadoUsuario::new));
    }

    @PutMapping
    @Transactional
        public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario = respository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),usuario.getEmail(),usuario.getPassword(),usuario.getPerfiles()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        Usuario usuario = respository.getReferenceById(id);
        usuario.desactivarUsuario();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> retornoDatosUsuario(@PathVariable Long id){
        Usuario usuario = respository.getReferenceById(id);
        var datosUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),usuario.getEmail(),usuario.getPassword(),usuario.getPerfiles());
        usuario.desactivarUsuario();
        return ResponseEntity.ok(datosUsuario);
    }
}
