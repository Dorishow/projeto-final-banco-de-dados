package com.santander.banco811.service;

import com.santander.banco811.dto.transacao.TransacaoRequest;
import com.santander.banco811.dto.transacao.TransacaoResponse;

import java.util.List;

public interface TransacaoService {
    TransacaoResponse create(TransacaoRequest transacaoRequest, Integer idContaRemetente);
    List<TransacaoResponse> findAll();
}
