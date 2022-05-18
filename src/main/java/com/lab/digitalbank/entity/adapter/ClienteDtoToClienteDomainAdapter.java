package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;

import java.util.Map;
import java.util.Objects;

public class ClienteDtoToClienteDomainAdapter {

    public Cliente converte(Map<String, Object> entrada){
        Cliente cliente = new Cliente();

        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("cliente") && Objects.nonNull(entrada.get("cliente"))){
                Map<String, Object> clienteMap = (Map<String, Object>) entrada.get("cliente");
                if (clienteMap.containsKey("nome") && Objects.nonNull(clienteMap.get("nome"))){
                    cliente.setNome(clienteMap.get("nome").toString());
                }
            }
        }
        return cliente;
    }
}
