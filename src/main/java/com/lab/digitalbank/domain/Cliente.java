package com.lab.digitalbank.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> conta;

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

//    public Conta getConta() {
//        return conta;
//    }
//
//    public Cliente setConta(Conta conta) {
//        this.conta = conta;
//        return this;
//    }


    public List<Conta> getConta() {
        return conta;
    }

    public Cliente setConta(List<Conta> conta) {
        this.conta = conta;
        return this;
    }
}
