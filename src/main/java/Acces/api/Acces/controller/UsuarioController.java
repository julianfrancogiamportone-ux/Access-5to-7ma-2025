package Acces.api.Acces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Usuario;
import Acces.api.Acces.service.UsuarioIService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "")
public class UsuarioController {

    @Autowired
    private UsuarioIService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    // Crear usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    // Eliminar usuario enviando el objeto
    @DeleteMapping
    public void deleteUsuario(@RequestBody Usuario usuario) {
        usuarioService.deleteUsuario(usuario);
    }

    // Eliminar todos los usuarios
    @DeleteMapping("/all")
    public void deleteAllUsuarios() {
        usuarioService.deleteAllUsuarios();
    }
}