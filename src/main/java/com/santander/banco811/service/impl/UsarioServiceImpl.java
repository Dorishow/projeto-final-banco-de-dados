package com.santander.banco811.service.impl;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repository.UsuarioRepository;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponse> getAll() {
        var usuarios = usuarioRepository.findAll();
        return UsuarioResponse.toResponse(usuarios);
    }

    @Override
    public Page<Usuario> getAllPaginated(Integer pagina, Integer qtdElementos) {
        PageRequest pageRequest = PageRequest.of(
                pagina, qtdElementos
        );
        return usuarioRepository.findAll(pageRequest);
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        var usuario = new Usuario(usuarioRequest);
        var usuarioResponse = new UsuarioResponse(usuarioRepository.save(usuario));
        return usuarioResponse;
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public UsuarioResponse getUserById(Integer id) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse deleteById(Integer id) {
        var usuario = findById(id);
        usuarioRepository.deleteById(id);
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse updateById(Integer id, UsuarioRequest usuarioRequest) {
        var usuario = findById(id);
        usuario.updateUsuario(usuarioRequest);
        usuarioRepository.save(usuario);
        var usuarioResponse = new UsuarioResponse(usuario);
        return usuarioResponse;
    }

    @Override
    public List<UsuarioResponse> getUserByNome(String nome) {
        return UsuarioResponse.toResponse(
                usuarioRepository.findByNome(nome)
        );
    }
}
