package com.santander.banco811.dto.transacao;

import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Transacao;
import com.santander.banco811.model.enums.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class TransacaoResponse {
    private Integer id;
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
    private Integer agencia;
    private ContaResponse conta;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.agencia = transacao.getAgencia();
        this.conta = new ContaResponse(transacao.getConta());
    }

    public static List<TransacaoResponse> toResponse(List<Transacao> transacoes){
        return transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());
    }
}
