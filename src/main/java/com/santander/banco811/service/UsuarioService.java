package com.santander.banco811.service;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponse> getAll();
    UsuarioResponse create(UsuarioRequest usuarioRequest);
    Usuario findById(Integer id);
    UsuarioResponse getUserById(Integer id);
    UsuarioResponse deleteById(Integer id);
    UsuarioResponse updateById(Integer id, UsuarioRequest usuarioRequest);
}
