package Acces.api.Acces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Acces.api.Acces.entity.Moneda;
import Acces.api.Acces.repository.MonedaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MonedaService implements MonedaIService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> findAllMonedas() {
        return monedaRepository.findAll();
    }

    @Override
    public Moneda saveMoneda(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public Optional<Moneda> findMonedaById(Long id) {
        return monedaRepository.findById(id);
    }

    @Override
    public void deleteMoneda(Long id) {
        monedaRepository.deleteById(id);
    }

    @Override
    public void deleteMoneda(Moneda moneda) {
        monedaRepository.delete(moneda);
    }

    @Override
    public void deleteAllMonedas() {
        monedaRepository.deleteAll();
    }
}
