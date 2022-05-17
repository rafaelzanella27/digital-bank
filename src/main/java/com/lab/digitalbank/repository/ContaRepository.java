package com.lab.digitalbank.repository;

import com.lab.digitalbank.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Integer> {


}
