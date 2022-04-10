package com.santander.banco811.dto.conta;

import com.santander.banco811.model.Usuario;
import com.santander.banco811.model.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaRequest {
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private Integer idUsuario;
}
