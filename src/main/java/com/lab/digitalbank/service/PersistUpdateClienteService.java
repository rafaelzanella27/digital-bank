package com.lab.digitalbank.service;

import com.lab.digitalbank.entity.AtualizaClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistUpdateClienteService {

    @Autowired
    SaveClienteService saveClienteService;

    public String execute(AtualizaClienteEntity atualizaClienteEntity){
        saveClienteService.execute(atualizaClienteEntity.geraSaida());
        return "Cliente atualizado com sucesso";
    }
}
