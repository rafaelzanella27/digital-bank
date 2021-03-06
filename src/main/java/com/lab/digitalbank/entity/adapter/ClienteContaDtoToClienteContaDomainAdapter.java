package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.enums.TipoConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ClienteContaDtoToClienteContaDomainAdapter {

    public List<Conta> converte(Map<String, Object> entrada, Cliente cliente){

        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("contas") && Objects.nonNull(entrada.get("contas"))){
                List<Conta> listaConta = new ArrayList<>();
                List<Conta> listContasManipulation = (List<Conta>) entrada.get("contas");

                for (int i = 0; i < listContasManipulation.size(); i++){
                    Map<String, Object> mapConta = (Map<String, Object>) listContasManipulation.get(i);
                    if (Objects.nonNull(mapConta)){
                        Conta conta = new Conta();
                        if (Objects.nonNull(mapConta.get("tipo"))){
                            conta.setTipoConta(TipoConta.fromString(mapConta.get("tipo").toString()));
                        }
                        if (Objects.nonNull(mapConta.get("saldo"))){
                            conta.setSaldo(Double.valueOf(mapConta.get("saldo").toString()));
                        }
                        if (Objects.nonNull(cliente)){
                            conta.setCliente(cliente);
                        }
                        listaConta.add(conta);
                    }
                }
                return listaConta;
            }
        }
        return null;
    }
}
