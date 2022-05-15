package com.lab.digitalbank.enums;

public enum TipoConta {

    CONTA_CORRENTE("conta-corrente"),
    CONTA_POUPANCA("conta-poupanca");

    private String tipoConta;

    TipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public static String toTipoConta(String value){
        for (TipoConta tipoConta : TipoConta.values()){
            if (tipoConta.toString().equalsIgnoreCase(value)){
                return tipoConta.getTipoConta();
            }
        }
        return null;
    }

    public static TipoConta fromString(String enumString){
        for (TipoConta tipoConta : TipoConta.values()){
            if (tipoConta.getTipoConta().equalsIgnoreCase(enumString)){
                return tipoConta;
            }
        }
        return null;
    }
}
