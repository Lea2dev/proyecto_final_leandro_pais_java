package com.talento.web.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.talento.web.model.Articulo;
import com.talento.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin(origins = "*") // test locales, quitar en produccion
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> listar() {
        return articuloService.listarArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createResource(@RequestBody Articulo articulo) {
        if(articulo.getNombre()==null || articulo.getNombre().isBlank()) return ResponseEntity.badRequest().body("Nombre de articulo requerido");
        Articulo nuevoArticulo = articuloService.guardarArticulo(articulo);
        return ResponseEntity.status(201).body(nuevoArticulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/buscar") // filtros
    public List<Articulo> buscar(
            // parametros opcionales, required false
            @RequestParam(required = false) String nombre,   
            @RequestParam(required = false) Double minPrecio, 
            @RequestParam(required = false) Double maxPrecio
    ) { 
        
        if (nombre != null && minPrecio != null && maxPrecio != null) { 
            return articuloService.buscarPorNombreYPrecioEntre(nombre, minPrecio, maxPrecio); 
        }
        else if (nombre != null && minPrecio == null && maxPrecio == null) { 
            return articuloService.buscarPorNombre(nombre); 
        }
        else if (nombre == null && minPrecio != null && maxPrecio != null) { 
            return articuloService.buscarPorPrecioEntre(minPrecio, maxPrecio); 
        }
        else if (minPrecio != null && maxPrecio == null && nombre == null) {
            return articuloService.buscarPorPrecioMinimo(minPrecio); 
        }
        else if (maxPrecio != null && minPrecio == null && nombre == null) { 
            return articuloService.buscarPorPrecioMaximo(maxPrecio); 
        }
        // si no se cumple nada lista todo
        return articuloService.listarArticulos();
    }

}
