package com.santander.banco811.service;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponse> getAll();
    Page<Usuario> getAllPaginated(Integer pagina, Integer qtdElementos);
    UsuarioResponse create(UsuarioRequest usuarioRequest);
    Usuario findById(Integer id);
    UsuarioResponse getUserById(Integer id);
    UsuarioResponse deleteById(Integer id);
    UsuarioResponse updateById(Integer id, UsuarioRequest usuarioRequest);
    List<UsuarioResponse> getUserByNome(String nome);
}
