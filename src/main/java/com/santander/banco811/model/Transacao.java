package com.santander.banco811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santander.banco811.dto.transacao.TransacaoRequest;
import com.santander.banco811.model.enums.TipoTransacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transacao")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "valor")
    BigDecimal valor;

    @Column(name = "tipo_transacao")
    @Enumerated(value = EnumType.STRING)
    TipoTransacao tipoTransacao;

    @Column(name = "numero")
    Integer numero;

    @Column(name = "agencia")
    Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    public Transacao(TransacaoRequest transacaoRequest){
        this.tipoTransacao = transacaoRequest.getTipoTransacao();
        this.agencia = transacaoRequest.getAgencia();
        this.valor = transacaoRequest.getValor();
        this.numero = transacaoRequest.getNumero();
    }

    public Transacao updateTransacao(TransacaoRequest transacaoRequest, Conta conta){
        if (conta != null){
            this.setConta(conta);
        }
        if(transacaoRequest.getTipoTransacao() != null){
            this.tipoTransacao = transacaoRequest.getTipoTransacao();
        }
        if(transacaoRequest.getValor() != null){
            this.valor = transacaoRequest.getValor();
        }
        if(transacaoRequest.getAgencia() != null){
            this.agencia = transacaoRequest.getAgencia();
        }
        return this;
    }
}
