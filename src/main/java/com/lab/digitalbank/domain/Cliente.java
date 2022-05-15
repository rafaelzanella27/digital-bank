package com.lab.digitalbank.domain;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private String nome;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Conta conta;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public Cliente setConta(Conta conta) {
        this.conta = conta;
        return this;
    }
}
