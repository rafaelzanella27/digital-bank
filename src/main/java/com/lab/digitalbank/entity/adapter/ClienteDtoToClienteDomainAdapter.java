package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.enums.TipoConta;

import java.util.Map;
import java.util.Objects;

public class ClienteDtoToClienteDomainAdapter {

    public Cliente converte(Map<String, Object> entrada){
        Cliente cliente = new Cliente();
        Conta conta = new Conta();
        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("cliente") && Objects.nonNull(entrada.get("cliente"))){
                Map<String, Object> clienteMap = (Map<String, Object>) entrada.get("cliente");
                if (clienteMap.containsKey("nome") && Objects.nonNull(clienteMap.get("nome"))){
                    cliente.setNome(clienteMap.get("nome").toString());
                }
            }
            if (entrada.containsKey("conta") && Objects.nonNull(entrada.get("conta"))){
                Map<String, Object> contaMap = (Map<String, Object>) entrada.get("conta");
                if (contaMap.containsKey("tipo") && Objects.nonNull(contaMap.get("tipo"))){
                    conta.setTipoConta(TipoConta.fromString(contaMap.get("tipo").toString()));
                    if (contaMap.containsKey("saldo") && Objects.nonNull(contaMap.get("saldo"))){
                        conta.setSaldo(Double.valueOf(contaMap.get("saldo").toString()));
                    }
                    cliente.setConta(conta);
                }
            }
        } return cliente;
    }
}
