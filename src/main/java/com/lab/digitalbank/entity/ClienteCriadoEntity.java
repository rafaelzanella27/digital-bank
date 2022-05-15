package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteCriadoToDtoAdapter;

import java.util.Map;

public class ClienteCriadoEntity {

    private Cliente cliente;

    private ClienteCriadoEntity(Cliente cliente){
        this.cliente = cliente;
    }

    public static ClienteCriadoEntity inicializa(Cliente cliente){
        return new ClienteCriadoEntity(cliente);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteCriadoToDtoAdapter().converte(cliente);
    }

}
