package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.adapter.ClienteContaCriadoToDtoAdapter;

import java.util.List;
import java.util.Map;

public class ClienteContaCriadoEntity {

    private Cliente cliente;
    private List<Conta> listaContas;

    private ClienteContaCriadoEntity(Cliente cliente, List<Conta> listaContas){
        this.cliente = cliente;
        this.listaContas = listaContas;
    }

    public static ClienteContaCriadoEntity inicializa(Cliente cliente, List<Conta> listaContas){
        return new ClienteContaCriadoEntity(cliente, listaContas);
    }

    public Map<String, Object> geraSaida(){
        return new ClienteContaCriadoToDtoAdapter().converte(cliente, listaContas);
    }

}
