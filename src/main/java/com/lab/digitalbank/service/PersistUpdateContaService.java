package com.lab.digitalbank.service;

import com.lab.digitalbank.entity.AtualizaContaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistUpdateContaService {

    @Autowired
    SaveContaService saveContaService;

    public String execute(AtualizaContaEntity atualizaContaEntity){
        saveContaService.execute(atualizaContaEntity.geraSaida());
        return "Conta atualizado com sucesso";
    }
}
