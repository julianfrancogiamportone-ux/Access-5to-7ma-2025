package Acces.api.Acces.service;

import Acces.api.Acces.entity.Compra;
import Acces.api.Acces.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements CompraIService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> obtenerCompraPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public Compra crearCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra actualizarCompra(Long id, Compra compraActualizada) {
        return compraRepository.findById(id).map(compra -> {
            compra.setMetodoPago(compraActualizada.getMetodoPago());
            compra.setDireccionEnvio(compraActualizada.getDireccionEnvio());
            compra.setTotal(compraActualizada.getTotal());
            compra.setFechaCompra(compraActualizada.getFechaCompra());
            compra.setCarrito(compraActualizada.getCarrito());
            return compraRepository.save(compra);
        }).orElseThrow(() -> new RuntimeException("Compra no encontrada con id: " + id));
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}