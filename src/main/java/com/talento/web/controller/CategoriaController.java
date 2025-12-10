package com.talento.web.controller;

import com.talento.web.model.Categoria;
import com.talento.web.service.CategoriaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService; 

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService; 
    } 

    @GetMapping
    public List<Categoria> listar() { 
        return categoriaService.listarCategorias();
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) { 
        return categoriaService.obtenerCategoriaPorId(id) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping 
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        
        if (categoriaService.obtenerCategoriaPorId(id).isEmpty()) { 
            return ResponseEntity.notFound().build(); 
        }
        Categoria actualizada = categoriaService.actualizarCategoria(id, categoria); 
        return ResponseEntity.ok(actualizada); 
    } 

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> eliminar(@PathVariable Long id) { 
        if (categoriaService.obtenerCategoriaPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }
        categoriaService.eliminarCategoria(id); 
        return ResponseEntity.noContent().build(); 
    } 

}
