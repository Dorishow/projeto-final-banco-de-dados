package com.santander.banco811.repository;

import com.santander.banco811.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    List<Conta> findByUsuario_cpf(String cpf);

    @Query(value = "SELECT * FROM USUARIO U " +
            "INNER JOIN CONTA C " +
            "ON C.USUARIO_ID = U.ID " +
            "where (c.agencia = :agencia) and (u.cpf = :cpf)", nativeQuery = true)
    List<Conta> findByAgenciaAndUsuario_cpf(
        @Param("agencia") Integer agencia,
        @Param("cpf") String cpf
    );
}
