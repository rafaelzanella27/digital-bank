package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteCriadoToDtoAdapter;

import java.util.Map;
import java.util.Objects;

public class AtualizaClienteEntity {

    private Cliente cliente;
    private Map<String, Object> entrada;

    private AtualizaClienteEntity(Map<String, Object> entrada, Cliente cliente){
        this.cliente = cliente;
        this.entrada = entrada;
    }

    public static AtualizaClienteEntity inicializa(Map<String, Object> entrada, Cliente cliente){
        return new AtualizaClienteEntity(entrada, cliente);
    }

    public Cliente geraSaida(){
        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("nome") && Objects.nonNull(entrada.get("nome"))){
                this.cliente.setNome(entrada.get("nome").toString());
            }
            return cliente;
        }
        return null;
    }

}
