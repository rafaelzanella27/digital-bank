package com.lab.digitalbank.repository;

import com.lab.digitalbank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    List<Conta> findAll();

    @Query("from Conta ct inner join Cliente c on ct.cliente = c.id where c.id = cliente_id")
    List<Conta> findAllByIdClient(@Param("cliente_id") Integer id);


}
