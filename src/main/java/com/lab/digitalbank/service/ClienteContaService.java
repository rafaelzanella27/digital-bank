package com.lab.digitalbank.service;

import com.lab.digitalbank.entity.NovoClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClienteContaService {

    @Autowired
    PersistCreateService persistCreateService;

    public Map<String, Object> novo(Map<String, Object> clienteDTO){
        try {
            NovoClienteEntity novoClienteEntity = NovoClienteEntity.inicializa(clienteDTO);
            return persistCreateService.execute(novoClienteEntity);
        }catch (RuntimeException e){
            e.getMessage();
        }
        return null;
    }

}
