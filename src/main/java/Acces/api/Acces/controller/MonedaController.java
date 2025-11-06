package Acces.api.Acces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Moneda;
import Acces.api.Acces.service.MonedaIService;

@RestController
@RequestMapping("/api/monedas")
@CrossOrigin(origins = "*")
public class MonedaController {

    @Autowired
    private MonedaIService monedaService;

    @GetMapping
    public List<Moneda> getAllMonedas() {
        return monedaService.findAllMonedas();
    }

    @GetMapping("/{id}")
    public Optional<Moneda> getMonedaById(@PathVariable Long id) {
        return monedaService.findMonedaById(id);
    }

    @PostMapping
    public Moneda createMoneda(@RequestBody Moneda moneda) {
        return monedaService.saveMoneda(moneda);
    }

    @DeleteMapping("/{id}")
    public void deleteMoneda(@PathVariable Long id) {
        monedaService.deleteMoneda(id);
    }

    @DeleteMapping
    public void deleteMoneda(@RequestBody Moneda moneda) {
        monedaService.deleteMoneda(moneda);
    }

    @DeleteMapping("/all")
    public void deleteAllMonedas() {
        monedaService.deleteAllMonedas();
    }
}
