package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteToDtoAdapter;

import java.util.Map;

public class CancelaClienteEntity {

    private Cliente cliente;

    private CancelaClienteEntity(Cliente cliente){
        this.cliente = cliente;
    }

    public static CancelaClienteEntity inicializa(Cliente cliente){
        return new CancelaClienteEntity(cliente);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteToDtoAdapter().converte(this.cliente);
    }

}
