package Acces.api.Acces.service;

import Acces.api.Acces.entity.Trailer;
import java.util.List;
import java.util.Optional;

public interface TrailerIService {

    List<Trailer> listarTodos();
    Optional<Trailer> buscarPorId(Long id);
    Trailer guardar(Trailer trailer);
    void eliminar(Long id);
}