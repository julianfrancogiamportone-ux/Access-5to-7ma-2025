package Acces.api.Acces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Acces.api.Acces.entity.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
}