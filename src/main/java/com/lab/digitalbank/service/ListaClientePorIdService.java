package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.ConsultaClienteEntity;
import com.lab.digitalbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ListaClientePorIdService {

    @Autowired
    ClienteRepository clienteRepository;

    public Map<String, Object> execute(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return retornaClienteEncontrado(cliente);
    }

    private Map<String, Object> retornaClienteEncontrado(Optional<Cliente> cliente){
        if (cliente.isEmpty()){
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("error", "Cliente não encontrado");
            return errorMap;
        }
        return ConsultaClienteEntity.inicializa(cliente.get()).geraSaida();
    }
}
