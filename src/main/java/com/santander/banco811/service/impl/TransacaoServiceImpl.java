package com.santander.banco811.service.impl;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.dto.transacao.TransacaoRequest;
import com.santander.banco811.dto.transacao.TransacaoResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.Transacao;
import com.santander.banco811.model.Usuario;
import com.santander.banco811.repository.TransacaoRepository;
import com.santander.banco811.service.ContaService;
import com.santander.banco811.service.TransacaoService;
import com.santander.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ContaService contaService;

    @Autowired
    UsuarioService usuarioService;


    @Override
    public TransacaoResponse create(TransacaoRequest transacaoRequest, Integer idContaRemetente) {
        Transacao transacao = new Transacao(transacaoRequest);

        ContaResponse contaRemetente = contaService.getById(idContaRemetente);

        if (contaRemetente.getSaldo().compareTo(transacao.getValor()) == 1) {
            BigDecimal saldoAtualRemetente = contaRemetente.getSaldo();
            ContaRequest subtrairValor = new ContaRequest();
            subtrairValor.setSaldo(saldoAtualRemetente.subtract(transacaoRequest.getValor()));
            contaService.updateById(idContaRemetente, subtrairValor);
        } else {
            transacaoRequest.setValor(BigDecimal.ZERO);
            throw new RuntimeException("O saldo é menor que o valor da transação");
        }


        Conta contaDestinatario = contaService.findById(transacaoRequest.getIdConta());
        ContaRequest transferirParaDestinatario = new ContaRequest();
        BigDecimal saldoAtualDoDestinatario = contaDestinatario.getSaldo();
        transferirParaDestinatario.setSaldo(saldoAtualDoDestinatario.add(transacaoRequest.getValor()));
        transacao.setConta(contaService.findById(contaDestinatario.getId()));
        Integer idDestinatario = contaDestinatario.getId();
        contaService.updateById(idDestinatario, transferirParaDestinatario);

        TransacaoResponse transacaoResponse = new TransacaoResponse(transacaoRepository.save(transacao));
        return transacaoResponse;
    }

    @Override
    public List<TransacaoResponse> findAll() {
        return TransacaoResponse.toResponse(transacaoRepository.findAll());
    }
}
