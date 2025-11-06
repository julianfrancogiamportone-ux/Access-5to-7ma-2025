package Acces.api.Acces.controller;

import Acces.api.Acces.entity.Trailer;
import Acces.api.Acces.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    // 🔹 Listar todos los trailers
    @GetMapping
    public List<Trailer> listarTodos() {
        return trailerService.listarTodos();
    }

    // 🔹 Buscar trailer por ID
    @GetMapping("/{id}")
    public Optional<Trailer> obtenerPorId(@PathVariable Long id) {
        return trailerService.buscarPorId(id);
    }

    // 🔹 Crear nuevo trailer
    @PostMapping
    public Trailer crearTrailer(@RequestBody Trailer trailer) {
        return trailerService.guardar(trailer);
    }

    // 🔹 Actualizar trailer existente
    @PutMapping("/{id}")
    public Trailer actualizarTrailer(@PathVariable Long id, @RequestBody Trailer trailer) {
        trailer.setId(id); // ahora sí, porque ya agregaste el setId() en la entidad
        return trailerService.guardar(trailer);
    }

    // 🔹 Eliminar trailer
    @DeleteMapping("/{id}")
    public void eliminarTrailer(@PathVariable Long id) {
        trailerService.eliminar(id);
    }
}