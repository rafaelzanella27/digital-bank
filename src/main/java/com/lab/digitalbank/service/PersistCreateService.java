package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.ClienteContaCriadoEntity;
import com.lab.digitalbank.entity.ClienteCriadoEntity;
import com.lab.digitalbank.entity.NovaContaEntity;
import com.lab.digitalbank.entity.NovoClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersistCreateService {

    @Autowired
    SaveClienteService saveClienteService;

    @Autowired
    SaveContaService saveContaService;

    public Map<String, Object> execute(NovoClienteEntity novoClienteEntity){
        Cliente cliente = saveClienteService.execute(novoClienteEntity.geraSaida());
        if (novoClienteEntity.possuiContas()){
            List<Conta> listContas = saveContaService.execute(NovaContaEntity.inicializa(novoClienteEntity.getEntrada(), cliente).geraSaida());
            ClienteContaCriadoEntity clienteContaCriadoEntity = ClienteContaCriadoEntity.inicializa(cliente,listContas);
            return clienteContaCriadoEntity.geraSaida();
        }
        ClienteCriadoEntity clienteCriadoEntity = ClienteCriadoEntity.inicializa(cliente);
        return clienteCriadoEntity.geraSaida();
    }
}
