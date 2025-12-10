package com.talento.web.service;

import com.talento.web.model.Categoria;

import java.util.List;    // List se usa para devolver listas de categorías
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listarCategorias(); 
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    Categoria guardarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);

}
