package com.santander.banco811.repository;

import com.santander.banco811.model.Usuario;
import com.santander.banco811.projection.UsuarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
}
