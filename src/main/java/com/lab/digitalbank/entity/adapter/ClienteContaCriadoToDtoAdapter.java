package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;

import java.util.*;

public class ClienteContaCriadoToDtoAdapter {

    public Map<String, Object> converte(Cliente cliente, List<Conta> listaContas){
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

            if (Objects.nonNull(listaContas)){
                List<Conta> listaContaManipulation = listaContas;
                List<Conta> listaConta = new ArrayList<>();

                if (Objects.nonNull(listaContaManipulation)){
                    for (int i = 0; i < listaContaManipulation.size(); i++){
                        Conta contaManipulation = listaContaManipulation.get(i);
                        listaConta.add(contaManipulation);
                    }
                }
            saída.put("Contas", listaConta);
            }
        }
        return saída;
    }
}
