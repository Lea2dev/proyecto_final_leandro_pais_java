package com.talento.web.service;

import com.talento.web.model.Articulo;
import com.talento.web.repository.ArticuloRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service // Marca la clase como servicio de Spring
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @SuppressWarnings("null")
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    @SuppressWarnings("null")
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}

