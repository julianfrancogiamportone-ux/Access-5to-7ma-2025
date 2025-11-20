package Acces.api.Acces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Acces.api.Acces.entity.Juego;
import Acces.api.Acces.repository.JuegoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService implements JuegoIService {

    @Autowired
    private JuegoRepository juegoRepository;

    @Override
    public List<Juego> findAllJuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public Juego saveJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public Optional<Juego> findJuegoById(Long id) {
        return juegoRepository.findById(id);
    }

    @Override
    public void deleteJuego(Long id) {
        juegoRepository.deleteById(id);
    }

    @Override
    public void deleteJuego(Juego juego) {
        juegoRepository.delete(juego);
    }

    @Override
    public void deleteAllJuegos() {
        juegoRepository.deleteAll();
    }
}