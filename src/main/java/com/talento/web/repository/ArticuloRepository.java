package com.talento.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.web.model.Articulo;


@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    
    // metodos de busqeuda

    List<Articulo> findByNombreContainingIgnoreCase(String nombre);

    List<Articulo> findByPrecioGreaterThanEqual(Double precioMinimo);

    List<Articulo> findByPrecioLessThanEqual(Double precioMaximo);

    List<Articulo> findByPrecioBetween(Double precioMinimo, Double precioMaximo);

    List<Articulo> findByNombreContainingIgnoreCaseAndPrecioBetween(String nombre, Double precioMinimo, Double precioMaximo);

}
