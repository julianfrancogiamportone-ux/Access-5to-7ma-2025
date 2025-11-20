package Acces.api.Acces.service;

import Acces.api.Acces.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraIService {

    List<Compra> listarCompras();
    Optional<Compra> obtenerCompraPorId(Long id);
    Compra crearCompra(Compra compra);
    Compra actualizarCompra(Long id, Compra compraActualizada);
    void eliminarCompra(Long id);
}