package Acces.api.Acces.service;

import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Juego;

public interface JuegoIService {
    List<Juego> findAllJuegos();
    Juego saveJuego(Juego juego);
    Optional<Juego> findJuegoById(Long id);
    void deleteJuego(Long id);
    void deleteJuego(Juego juego);
    void deleteAllJuegos();
}