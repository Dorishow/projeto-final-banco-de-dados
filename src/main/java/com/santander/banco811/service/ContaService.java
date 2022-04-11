package com.santander.banco811.service;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.enums.TipoConta;
import com.santander.banco811.projection.ContaView;

import java.util.List;

public interface ContaService {
    List<ContaResponse> getAll();
    ContaResponse create(ContaRequest contaRequest);
    ContaResponse updateById(Integer id, ContaRequest contaRequest);
    ContaResponse getById(Integer id);
    ContaResponse deleteById(Integer id);
    List<ContaResponse> getByUsuarioCpf(String cpf);
    List<ContaResponse> findByAgenciaAndUsuario_cpf(Integer agencia, String cpf);
    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);
    Conta findById(Integer id);
}
