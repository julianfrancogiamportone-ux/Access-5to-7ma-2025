package Acces.api.Acces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Acces.api.Acces.entity.Carrito;
import Acces.api.Acces.repository.CarritoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService implements CarritoIService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> findAllCarritos() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        carrito.calcularTotal(); // recalcula total antes de guardar
        return carritoRepository.save(carrito);
    }

    @Override
    public Optional<Carrito> findCarritoById(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public void deleteCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public void deleteCarrito(Carrito carrito) {
        carritoRepository.delete(carrito);
    }

    @Override
    public void deleteAllCarritos() {
        carritoRepository.deleteAll();
    }
}
