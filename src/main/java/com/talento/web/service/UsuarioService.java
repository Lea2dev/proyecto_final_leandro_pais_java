package com.talento.web.service;

import com.talento.web.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    // busquedas
    List<Usuario> buscarPoruserName(String userName); 
}
