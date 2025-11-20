package Acces.api.Acces.service;

import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Usuario;

public interface UsuarioIService {
    List<Usuario> findAllUsuarios();
    Usuario saveUsuario(Usuario usuario);
    Optional<Usuario> findUsuarioById(Long id);
    void deleteUsuario(Long id);
    void deleteUsuario(Usuario usuario);
    void deleteAllUsuarios();
}