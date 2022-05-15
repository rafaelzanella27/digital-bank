package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.ClienteCriadoEntity;
import com.lab.digitalbank.entity.NovoClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistCreateService {

    @Autowired
    SaveClienteService saveClienteService;

    public ClienteCriadoEntity execute(NovoClienteEntity novoClienteEntity){
        Cliente cliente = saveClienteService.execute(novoClienteEntity.geraSaida());
        ClienteCriadoEntity clienteCriadoEntity = ClienteCriadoEntity.inicializa(cliente);
        return clienteCriadoEntity;
    }
}
