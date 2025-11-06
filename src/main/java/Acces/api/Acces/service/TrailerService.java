package Acces.api.Acces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Acces.api.Acces.entity.Trailer;
import Acces.api.Acces.repository.TrailerRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TrailerService {

    @Autowired
    private TrailerRepository trailerRepository;

    public List<Trailer> listarTodos() {
        return trailerRepository.findAll();
    }

    public Optional<Trailer> buscarPorId(Long id) {
        return trailerRepository.findById(id);
    }

    public Trailer guardar(Trailer trailer) {
        return trailerRepository.save(trailer);
    }

    public void eliminar(Long id) {
        trailerRepository.deleteById(id);
    }
}