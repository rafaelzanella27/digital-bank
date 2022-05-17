package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.enums.TipoConta;

import java.util.Map;
import java.util.Objects;

public class AtualizaContaEntity {

    private Conta conta;
    private Map<String, Object> entrada;

    private AtualizaContaEntity(Map<String, Object> entrada, Conta conta){
        this.conta = conta;
        this.entrada = entrada;
    }

    public static AtualizaContaEntity inicializa(Map<String, Object> entrada, Conta conta){
        return new AtualizaContaEntity(entrada, conta);
    }

    public Conta geraSaida(){
        if (Objects.nonNull(entrada)){
            if (entrada.containsKey("tipo") && Objects.nonNull(entrada.get("tipo"))){
                this.conta.setTipoConta(TipoConta.fromString(entrada.get("tipo").toString()));
            }
            return conta;
        }
        return null;
    }

}
