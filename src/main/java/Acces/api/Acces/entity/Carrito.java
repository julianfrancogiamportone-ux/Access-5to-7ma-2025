package Acces.api.Acces.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "carrito_juego",
        joinColumns = @JoinColumn(name = "carrito_id"),
        inverseJoinColumns = @JoinColumn(name = "juego_id")
    )
    private List<Juego> juego = new ArrayList<>();

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private Double total = 0.0;

    // --- Constructor vacío ---
    public Carrito() {}

    // --- Lógica para calcular el total ---
    public void calcularTotal() {
        this.total = juego.stream()
                           .mapToDouble(Juego::getPrecio)
                           .sum();
    }

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Juego> getJuegos() {
        return juego;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juego = juegos;
        calcularTotal();
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    // --- Métodos auxiliares ---
    public void agregarJuego(Juego juego) {
        juego.add(juego);
        calcularTotal();
    }

    public void eliminarJuego(Juego juego) {
        juego.remove(juego);
        calcularTotal();
    }
}
