package com.talento.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity 
@Table(name = "categorias") // creamos tabla categoria
public class Categoria {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
    @Column(name = "id")
    private Long id;

    //@Column(name = "nombre", nullable = false, length = 200) // Columna para el nombre, obligatorio
    private String nombre; // Nombre de la categoría (ej: "Electrónica", "Hogar", etc.)

    //@Column(name = "descripcion", nullable = true, length = 500) // Descripción opcional, hasta 500 caracteres
    private String descripcion; // Descripción más detallada de la categoría

    public Categoria() {} 

    public Categoria(Long id, String nombre, String descripcion) { 
        this.id = id;
        this.nombre = nombre;
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

    public String getDescripcion() { 
        return descripcion; 
    } 

    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    } 
}
