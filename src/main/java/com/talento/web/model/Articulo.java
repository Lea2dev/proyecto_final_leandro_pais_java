package com.talento.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo extends Producto {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "imagen", nullable = true, length = 500)
    private String imagen;
    @ManyToOne // Un artículo pertenece a una sola categoría, pero una categoría puede tener muchos artículos
    @JoinColumn(name = "categoria_id") // Nombre de la columna que guarda la clave foránea hacia Categoria
    private Categoria categoria; // Referencia a la categoría asociada al artículo    

    public Articulo() {}

    public Articulo(Long id, String nombre, double precio, Categoria categoria, String imagen) {
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
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) { 
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
