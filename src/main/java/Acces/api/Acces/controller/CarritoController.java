package Acces.api.Acces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Carrito;
import Acces.api.Acces.service.CarritoIService;

@RestController
@RequestMapping("/api/carritos")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private CarritoIService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.findAllCarritos();
    }

    @GetMapping("/{id}")
    public Optional<Carrito> getCarritoById(@PathVariable Long id) {
        return carritoService.findCarritoById(id);
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.saveCarrito(carrito);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Long id) {
        carritoService.deleteCarrito(id);
    }

    @DeleteMapping
    public void deleteCarrito(@RequestBody Carrito carrito) {
        carritoService.deleteCarrito(carrito);
    }

    @DeleteMapping("/all")
    public void deleteAllCarritos() {
        carritoService.deleteAllCarritos();
    }
}

