package com.lab.digitalbank.service;

import com.lab.digitalbank.entity.ClienteCriadoEntity;
import com.lab.digitalbank.entity.NovoClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    PersistCreateService persistCreateService;
    @Autowired
    ListaClientePorIdService listaClientePorIdService;

    public Map<String, Object> salvar(Map<String, Object> clienteDTO){
        try {
            NovoClienteEntity novoClienteEntity = NovoClienteEntity.inicializa(clienteDTO);
            ClienteCriadoEntity clienteCriadoEntity = persistCreateService.execute(novoClienteEntity);
            return clienteCriadoEntity.geraSaida();
        }catch (RuntimeException e){
            e.getMessage();
        }
        return null;
    }

    public Map<String, Object> listarCliente(Long id){
        return listaClientePorIdService.execute(id);
    }
}
