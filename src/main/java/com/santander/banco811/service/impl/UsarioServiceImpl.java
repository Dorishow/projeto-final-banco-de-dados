package com.santander.banco811.service.impl;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repository.UsuarioRepository;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
        var usuarioResponse = new UsuarioResponse(usuario);
        usuarioRepository.deleteById(id);
        return usuarioResponse;
    }

    @Override
    public UsuarioResponse updateById(Integer id, UsuarioRequest usuarioRequest) {
        var usuario = findById(id);
        usuario.setNome(usuarioRequest.getNome());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setCpf(usuarioRequest.getCpf());
        var usuarioResponse = new UsuarioResponse(usuario);
        usuarioRepository.save(usuario);
        return usuarioResponse;
    }
}
