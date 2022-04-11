package com.santander.banco811.dto.transacao;

import com.santander.banco811.model.enums.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransacaoRequest {
    private BigDecimal valor;
    private Integer numero;
    private TipoTransacao tipoTransacao;
    private Integer agencia;
    private Integer idConta;
}
