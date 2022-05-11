package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SaveClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente execute(Cliente cliente){
        try{
            return clienteRepository.save(cliente);
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMostSpecificCause().getMessage());
        }
        return null;
    }
}
