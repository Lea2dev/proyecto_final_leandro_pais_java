package com.talento.web.service;

import com.talento.web.model.Articulo;

import java.util.List;
import java.util.Optional;


public interface ArticuloService {
    List<Articulo> listarArticulos();
    Optional<Articulo> obtenerArticuloPorId(Long id);
    Articulo guardarArticulo(Articulo articulo);
    Articulo actualizarArticulo(Long id, Articulo articulo);
    void eliminarArticulo(Long id);
    // busquedas
    List<Articulo> buscarPorNombre(String nombre); 
    List<Articulo> buscarPorPrecioMinimo(Double precioMinimo); 
    List<Articulo> buscarPorPrecioMaximo(Double precioMaximo); 
    List<Articulo> buscarPorPrecioEntre(Double precioMinimo, Double precioMaximo); 
    List<Articulo> buscarPorNombreYPrecioEntre(String nombre, Double precioMinimo, Double precioMaximo);
    List<Articulo> buscarPorNombreYminPrecio(String nombre, Double minPrecio);
    List<Articulo> buscarPorNombreYmaxPrecio(String nombre, Double maxPrecio); 
}
