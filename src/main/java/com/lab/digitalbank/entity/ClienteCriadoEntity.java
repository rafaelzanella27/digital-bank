package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.adapter.ClienteCriadoToDtoAdapter;

import java.util.Map;

public class ClienteCriadoEntity {

    private Map<String,Object> entrada;
    private Cliente cliente;

    private ClienteCriadoEntity(Map<String, Object> entrada, Cliente cliente){
        this.entrada = entrada;
        this.cliente = cliente;
    }

    public static ClienteCriadoEntity inicializa(Map<String, Object> entrada, Cliente cliente){
        return new ClienteCriadoEntity(entrada, cliente);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteCriadoToDtoAdapter().converte(entrada, cliente);
    }

}
