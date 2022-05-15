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

            if (Objects.nonNull(cliente.getConta())){
                Map<String, Object> contaSaída = new HashMap<>();
                if (Objects.nonNull(cliente.getConta().getAgencia())){
                    contaSaída.put("Agencia", cliente.getConta().getAgencia());
                }
                if (Objects.nonNull(cliente.getConta().getNumero())){
                    contaSaída.put("Numero", cliente.getConta().getNumero());
                }
                if (Objects.nonNull(cliente.getConta().getTipoConta())){
                    contaSaída.put("TipoDaConta", cliente.getConta().getTipoConta());
                }
                if (Objects.nonNull(cliente.getConta().getSaldo())){
                    contaSaída.put("Saldo", cliente.getConta().getSaldo());
                }
                saída.put("Conta", contaSaída);
            }
        }
        return saída;
    }
}
