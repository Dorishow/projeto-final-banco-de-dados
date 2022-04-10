package com.santander.banco811.service;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;

import java.util.List;

public interface ContaService {
    List<ContaResponse> getAll();
    ContaResponse create(ContaRequest contaRequest);
}
