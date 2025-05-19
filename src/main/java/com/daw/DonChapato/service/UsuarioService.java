package com.daw.DonChapato.service;

import com.daw.DonChapato.model.Usuario;
import com.daw.DonChapato.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Integer id, Usuario nuevoUsuario) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(nuevoUsuario.getNombre());
                    usuario.setApellidoPaterno(nuevoUsuario.getApellidoPaterno());
                    usuario.setApellidoMaterno(nuevoUsuario.getApellidoMaterno());
                    usuario.setCorreo(nuevoUsuario.getCorreo());
                    usuario.setTelefono(nuevoUsuario.getTelefono());
                    usuario.setContrasena(nuevoUsuario.getContrasena());
                    usuario.setRol(nuevoUsuario.getRol());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
