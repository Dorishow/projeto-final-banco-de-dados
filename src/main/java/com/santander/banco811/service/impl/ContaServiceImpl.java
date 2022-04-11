package com.santander.banco811.service.impl;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.enums.TipoConta;
import com.santander.banco811.projection.ContaView;
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

    @Override
    public ContaResponse updateById(Integer id, ContaRequest contaRequest) {
        var conta = contaRepository.findById(id).orElseThrow();
        var usuario = usuarioService.findById(contaRequest.getIdUsuario());
        conta.updateConta(contaRequest, usuario);
        return new ContaResponse(contaRepository.save(conta));
    }

    @Override
    public ContaResponse getById(Integer id) {
        var conta = contaRepository.findById(id).orElseThrow();
        return new ContaResponse(conta);
    }

    @Override
    public ContaResponse deleteById(Integer id) {
        var conta = contaRepository.findById(id).orElseThrow();
        contaRepository.deleteById(id);
        return new ContaResponse(conta);
    }

    @Override
    public List<ContaResponse> getByUsuarioCpf(String cpf) {
        var contas = contaRepository.findByUsuario_cpf(cpf);
        return ContaResponse.toResponse(contas);
    }

    @Override
    public List<ContaResponse> findByAgenciaAndUsuario_cpf(Integer agencia, String cpf) {
        var contas = contaRepository.findByAgenciaAndUsuario_cpf(agencia, cpf);
        return ContaResponse.toResponse(contas);
    }

    public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta){
        return contaRepository.findAllByTipoConta(tipoConta);
    }
}
