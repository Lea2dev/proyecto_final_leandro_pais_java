package com.talento.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.web.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // metodos de busqeuda

    List<Usuario> findByuserNameContainingIgnoreCase(String userName);

}
