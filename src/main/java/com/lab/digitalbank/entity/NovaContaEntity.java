package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.adapter.ClienteContaDtoToClienteContaDomainAdapter;
import com.lab.digitalbank.entity.adapter.ClienteDtoToClienteDomainAdapter;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NovaContaEntity {

    private Map<String, Object> entrada;
    private Cliente cliente;

    private NovaContaEntity(Map<String, Object> entrada, Cliente cliente){
        this.entrada = entrada;
        this.cliente = cliente;
    }

    public static NovaContaEntity inicializa(Map<String, Object> entrada, Cliente cliente){
        return new NovaContaEntity(entrada, cliente);
    }

    public List<Conta> geraSaida(){
        if (Objects.nonNull(cliente)){
            List<Conta> listConta = new ClienteContaDtoToClienteContaDomainAdapter().converte(this.entrada, this.cliente);
            return listConta;
        }
        return null;
    }
}
