package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;

import java.util.Map;
import java.util.Objects;

public class ClienteDtoToClienteDomainAdapter {

    public Cliente converte(Map<String, Object> entrada){
        Cliente cliente = new Cliente();
        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("nome") && Objects.nonNull(entrada.get("nome"))){
                cliente.setNome(entrada.get("nome").toString());
            }
        } return cliente;
    }
}
