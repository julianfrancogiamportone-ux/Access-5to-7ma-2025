package Acces.api.Acces.service;

import Acces.api.Acces.entity.Trailer;
import Acces.api.Acces.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrailerService implements TrailerIService {

    @Autowired
    private TrailerRepository trailerRepository;

    @Override
    public List<Trailer> listarTodos() {
        return trailerRepository.findAll();
    }

    @Override
    public Optional<Trailer> buscarPorId(Long id) {
        return trailerRepository.findById(id);
    }

    @Override
    public Trailer guardar(Trailer trailer) {
        return trailerRepository.save(trailer);
    }

    @Override
    public void eliminar(Long id) {
        trailerRepository.deleteById(id);
    }
}