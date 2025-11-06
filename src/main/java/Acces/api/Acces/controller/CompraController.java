package Acces.api.Acces.controller;

import Acces.api.Acces.entity.Compra;
import Acces.api.Acces.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerCompraPorId(@PathVariable Long id) {
        return compraService.obtenerCompraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra compra) {
        Compra nuevaCompra = compraService.crearCompra(compra);
        return ResponseEntity.ok(nuevaCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Long id, @RequestBody Compra compra) {
        try {
            Compra actualizada = compraService.actualizarCompra(id, compra);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }
}