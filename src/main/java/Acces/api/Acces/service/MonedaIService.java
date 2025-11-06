package Acces.api.Acces.service;

import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Moneda;

public interface MonedaIService {
    List<Moneda> findAllMonedas();
    Moneda saveMoneda(Moneda moneda);
    Optional<Moneda> findMonedaById(Long id);
    void deleteMoneda(Long id);
    void deleteMoneda(Moneda moneda);
    void deleteAllMonedas();
}

