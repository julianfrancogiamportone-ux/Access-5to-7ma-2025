package Acces.api.Acces.service;

import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Carrito;

public interface CarritoIService {
    List<Carrito> findAllCarritos();
    Carrito saveCarrito(Carrito carrito);
    Optional<Carrito> findCarritoById(Long id);
    void deleteCarrito(Long id);
    void deleteCarrito(Carrito carrito);
    void deleteAllCarritos();
}

