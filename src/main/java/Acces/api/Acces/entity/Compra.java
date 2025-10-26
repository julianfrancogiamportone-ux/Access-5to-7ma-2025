package Acces.api.Acces.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metodoPago;   // ejemplo: "Tarjeta de crédito", "MercadoPago", etc.
    private String direccionEnvio;
    private Double total;
    private LocalDateTime fechaCompra;

    // Relación con el carrito
    @OneToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    // Constructor vacío
    public Compra() {}

    // Constructor con parámetros
    public Compra(String metodoPago, String direccionEnvio, Double total, LocalDateTime fechaCompra, Carrito carrito) {
        this.metodoPago = metodoPago;
        this.direccionEnvio = direccionEnvio;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.carrito = carrito;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
