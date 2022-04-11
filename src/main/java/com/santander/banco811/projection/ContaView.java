package com.santander.banco811.projection;

import com.santander.banco811.model.enums.TipoConta;
import org.springframework.beans.factory.annotation.Value;

public interface ContaView {
    Integer getSaldo();
    TipoConta getTipoConta();
    @Value("#{'numero da conta: ' + target.numero + ' - ' + 'agencia: ' + target.agencia}")
    String getNumeroAgencia();
    UsuarioView getUsuario();
}
