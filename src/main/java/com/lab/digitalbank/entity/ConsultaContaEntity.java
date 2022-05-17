package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.adapter.ContaToDtoAdapter;

import java.util.List;
import java.util.Map;

public class ConsultaContaEntity {

    private List<Conta> conta;

    private ConsultaContaEntity(List<Conta> conta){
        this.conta = conta;
    }

    public static ConsultaContaEntity inicializa(List<Conta> conta){
        return new ConsultaContaEntity(conta);
    }

    public Map<String, Object> geraSaida(){
        return new ContaToDtoAdapter().converte(this.conta);
    }
}
