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

    @Override
    public List<Articulo> buscarPorNombre(String nombre) {
        // TODO Auto-generated method stub
        return articuloRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Articulo> buscarPorPrecioMinimo(Double precioMinimo) {
        // TODO Auto-generated method stub
        return articuloRepository.findByPrecioGreaterThanEqual(precioMinimo);
    }

    @Override
    public List<Articulo> buscarPorPrecioMaximo(Double precioMaximo) {
        // TODO Auto-generated method stub
        return articuloRepository.findByPrecioLessThanEqual(precioMaximo);
    }

    @Override
    public List<Articulo> buscarPorPrecioEntre(Double precioMinimo, Double precioMaximo) {
        // TODO Auto-generated method stub
        return articuloRepository.findByPrecioBetween(precioMinimo, precioMaximo);
    }

    @Override
    public List<Articulo> buscarPorNombreYPrecioEntre(String nombre, Double precioMinimo, Double precioMaximo) {
        // TODO Auto-generated method stub
        return articuloRepository.findByNombreContainingIgnoreCaseAndPrecioBetween(nombre, precioMinimo, precioMaximo);
    }

    @Override
    public List<Articulo> buscarPorNombreYminPrecio(String nombre, Double minPrecio) {
        // TODO Auto-generated method stub
        return articuloRepository.findByNombreContainingIgnoreCaseAndPrecioGreaterThan(nombre, minPrecio);
    }

    @Override
    public List<Articulo> buscarPorNombreYmaxPrecio(String nombre, Double maxPrecio) {
        // TODO Auto-generated method stub
        return articuloRepository.findByNombreContainingIgnoreCaseAndPrecioLessThan(nombre, maxPrecio);
    }
}

