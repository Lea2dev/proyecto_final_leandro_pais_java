package com.talento.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo extends Producto {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;

    private String nombre;
    private double precio;
    private String categoria;
    private String imagen;

    public Articulo() {}

    public Articulo(Long id, String nombre, double precio, String categoria, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.categoria = categoria;
        this.imagen = imagen;
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
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) { 
        this.categoria = categoria;
    }

    @Override
    public double aplicarDescuento() {
        return getPrecio() * 0.90;
    }

    @Override
    public String toString() {  
        return super.toString() + ", categoria=" + categoria;
    }
}
