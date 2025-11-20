package Acces.api.Acces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import Acces.api.Acces.entity.Juego;
import Acces.api.Acces.service.JuegoIService;

@RestController
@RequestMapping("/api/juegos")
@CrossOrigin(origins = "")
public class JuegoController {

    @Autowired
    private JuegoIService juegoService;


    @GetMapping
    public List<Juego> getAllJuegos() {
        return juegoService.findAllJuegos();
    }


    @GetMapping("/{id}")
    public Optional<Juego> getJuegoById(@PathVariable Long id) {
        return juegoService.findJuegoById(id);
    }


    @PostMapping
    public Juego createJuego(@RequestBody Juego juego) {
        return juegoService.saveJuego(juego);
    }


    @DeleteMapping("/{id}")
    public void deleteJuego(@PathVariable Long id) {
        juegoService.deleteJuego(id);
    }


    @DeleteMapping
    public void deleteJuego(@RequestBody Juego juego) {
        juegoService.deleteJuego(juego);
    }


    @DeleteMapping("/all")
    public void deleteAllJuegos() {
        juegoService.deleteAllJuegos();
    }
}
