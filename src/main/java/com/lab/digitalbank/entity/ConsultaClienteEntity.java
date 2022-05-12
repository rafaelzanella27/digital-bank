package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteToDtoAdapter;

import java.util.Map;

public class ConsultaClienteEntity {

    private Cliente cliente;

    private ConsultaClienteEntity(Cliente cliente){
        this.cliente = cliente;
    }

    public static ConsultaClienteEntity inicializa(Cliente cliente){
        return new ConsultaClienteEntity(cliente);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteToDtoAdapter().converte(this.cliente);
    }
}
