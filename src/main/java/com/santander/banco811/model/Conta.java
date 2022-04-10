package com.santander.banco811.model;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.model.enums.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "conta")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Conta(ContaRequest contaRequest){
        this.numero = contaRequest.getNumero();
        this.agencia = contaRequest.getAgencia();
        this.saldo = contaRequest.getSaldo();
        this.tipoConta = contaRequest.getTipoConta();
    }

    public Conta updateConta(ContaRequest contaRequest, Usuario usuario){
        if(usuario != null)
            this.usuario = usuario;
        if(contaRequest.getTipoConta() != null)
            this.tipoConta = contaRequest.getTipoConta();
        if(contaRequest.getAgencia() != null)
            this.agencia = contaRequest.getAgencia();
        if(contaRequest.getNumero() != null)
            this.numero = contaRequest.getNumero();
        if(contaRequest.getSaldo() != null)
            this.saldo = contaRequest.getSaldo();
        return this;
    }
}
