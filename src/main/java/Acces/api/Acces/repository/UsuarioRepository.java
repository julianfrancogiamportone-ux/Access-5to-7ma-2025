package Acces.api.Acces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Acces.api.Acces.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}