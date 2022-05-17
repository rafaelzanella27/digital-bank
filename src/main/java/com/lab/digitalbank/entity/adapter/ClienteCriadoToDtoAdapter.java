package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClienteCriadoToDtoAdapter {

    public Map<String, Object> converte(Cliente cliente){
        Map<String, Object> saída = new HashMap<>();
        if (Objects.nonNull(cliente)){
            Map<String, Object> clienteSaída = new HashMap<>();
            if (Objects.nonNull(cliente.getNome())){
                clienteSaída.put("nome", cliente.getNome());
            }
            if (Objects.nonNull(cliente.getId())){
                clienteSaída.put("id", cliente.getId());
            }
            saída.put("Cliente", clienteSaída);
        }
        return saída;
    }
}
