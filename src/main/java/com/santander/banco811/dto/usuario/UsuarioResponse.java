package com.santander.banco811.dto.usuario;

import com.santander.banco811.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataCriacao = usuario.getDataCriacao();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}
