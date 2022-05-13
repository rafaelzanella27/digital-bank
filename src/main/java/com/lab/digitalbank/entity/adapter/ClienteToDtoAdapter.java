package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClienteToDtoAdapter {

    public Map<String, Object> converte(Cliente cliente){
        Map<String, Object> clienteDto = new HashMap<>();
        if (Objects.nonNull(cliente)){
            clienteDto.put("nome", cliente.getNome());
            clienteDto.put("id", cliente.getId());
            if (Objects.nonNull(cliente.getConta())){
                clienteDto.put("Conta", cliente.getConta());
            }

        }
        return clienteDto;
    }
}
