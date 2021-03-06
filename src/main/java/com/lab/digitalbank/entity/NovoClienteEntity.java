package com.lab.digitalbank.entity;

import com.lab.digitalbank.entity.adapter.ClienteDtoToClienteDomainAdapter;
import com.lab.digitalbank.domain.Cliente;

import java.util.Map;
import java.util.Objects;

public class NovoClienteEntity {

    private Map<String,Object> entrada;

    private NovoClienteEntity(Map<String, Object> entrada){
        this.entrada = entrada;
    }

    public static NovoClienteEntity inicializa(Map<String, Object> entrada){
        return new NovoClienteEntity(entrada);
    }

    public Cliente geraSaida(){
        if (Objects.nonNull(entrada)){
            return new ClienteDtoToClienteDomainAdapter().converte(this.entrada);
        }
        return null;
    }

    public Map<String, Object> getEntrada(){
        return this.entrada;
    }

    public Boolean possuiContas(){
        return this.entrada.containsKey("contas");
    }
}
