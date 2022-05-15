package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteToDtoAdapter;

import java.util.Map;

public class DeletarClienteEntity {

    private Cliente cliente;

    private DeletarClienteEntity(Cliente cliente){
        this.cliente = cliente;
    }

    public static DeletarClienteEntity inicializa(Cliente cliente){
        return new DeletarClienteEntity(cliente);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteToDtoAdapter().converte(this.cliente);
    }

}
