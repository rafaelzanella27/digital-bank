package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> execute(List<Conta> listaContas){
        try{
            return contaRepository.saveAll(listaContas);
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMostSpecificCause().getMessage());
        }
        return null;
    }
}
