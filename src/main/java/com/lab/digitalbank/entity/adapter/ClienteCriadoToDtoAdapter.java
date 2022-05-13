package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;

import java.util.Map;
import java.util.Objects;

public class ClienteCriadoToDtoAdapter {

    public Map<String, Object> converte(Map<String, Object> entrada, Cliente cliente){
        if (Objects.nonNull(cliente)){
            entrada.put("nome", cliente.getNome());
            entrada.put("id", cliente.getId());
            if (Objects.nonNull(cliente.getConta())){
                entrada.put("Conta", cliente.getConta());
            }
        }
        return entrada;
    }
}
