package Acces.api.Acces.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    private String nombre;
    private double precio;
    private String imagen;
    private String descripcion;

   
    public Juego() {
    }

  
    public Juego(String nombre, double precio, String imagen, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 
    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}