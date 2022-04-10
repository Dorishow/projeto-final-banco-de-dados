package com.santander.banco811.service.impl;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.repository.ContaRepository;
import com.santander.banco811.service.ContaService;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public List<ContaResponse> getAll() {
        var contas = contaRepository.findAll();
        return ContaResponse.toResponse(contas);
    }

    @Override
    public ContaResponse create(ContaRequest contaRequest) {
        Conta conta = new Conta(contaRequest);
        var usuario = usuarioService.findById(contaRequest.getIdUsuario());
        conta.setUsuario(usuario);
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }
}