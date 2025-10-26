package Acces.api.Acces.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double saldo = 0.0;

    private LocalDateTime ultimaActualizacion = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private Usuario usuario;

    // --- Constructor vacío ---
    public Moneda() {}

    // --- Constructor con usuario ---
    public Moneda(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 0.0;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    // --- Métodos de lógica ---
    public void agregarSaldo(Double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            this.ultimaActualizacion = LocalDateTime.now();
        }
    }

    public boolean usarSaldo(Double cantidad) {
        if (cantidad <= saldo && cantidad > 0) {
            this.saldo -= cantidad;
            this.ultimaActualizacion = LocalDateTime.now();
            return true;
        }
        return false; // saldo insuficiente o cantidad inválida
    }

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
