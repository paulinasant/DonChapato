package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Usuario;
import com.daw.DonChapato.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            Usuario updatedUsuario = usuario.get();
            updatedUsuario.setNombre(usuarioDetails.getNombre());
            updatedUsuario.setApellidoP(usuarioDetails.getApellidoP());
            updatedUsuario.setApellidoS(usuarioDetails.getApellidoS());
            updatedUsuario.setTelefono(usuarioDetails.getTelefono());
            updatedUsuario.setCorreo(usuarioDetails.getCorreo());
            updatedUsuario.setRol(usuarioDetails.getRol());
            return ResponseEntity.ok(usuarioService.save(updatedUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}