package com.lab.digitalbank.domain;

import com.lab.digitalbank.enums.TipoConta;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "conta")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Conta {

    private static final Integer AGENCIA_PADRAO = 1;

    @Column
    private Integer agencia = AGENCIA_PADRAO;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer numero;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column
    private double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Conta setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Conta setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
        return this;
    }

    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }


    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
