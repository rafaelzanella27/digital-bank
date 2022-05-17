package com.lab.digitalbank.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String nome;

//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//    private List<Conta> conta;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Conta> getConta() {
//        return conta;
//    }
//
//    public Cliente setConta(List<Conta> conta) {
//        this.conta = conta;
//        return this;
//    }
}
