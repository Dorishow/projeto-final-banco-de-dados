package com.santander.banco811.model;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name ="senha")
    private String senha;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "usuario")
    private List<Conta> contas;

    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.cpf = usuarioRequest.getCpf();
        this.senha = usuarioRequest.getSenha();
    }

    public Usuario updateUsuario(UsuarioRequest usuarioRequest){
        if(usuarioRequest.getCpf() != null)
            this.cpf = usuarioRequest.getCpf();
        if(usuarioRequest.getSenha() != null)
            this.senha = usuarioRequest.getSenha();
        if(usuarioRequest.getNome() != null)
            this.nome = usuarioRequest.getNome();
        return this;
    }
}
