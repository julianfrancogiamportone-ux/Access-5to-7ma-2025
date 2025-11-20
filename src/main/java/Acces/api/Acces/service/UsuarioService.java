package Acces.api.Acces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Acces.api.Acces.entity.Usuario;
import Acces.api.Acces.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioIService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public void deleteAllUsuarios() {
        usuarioRepository.deleteAll();
    }
}