package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SaveContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta execute(Conta conta){
        try{
            return contaRepository.save(conta);
        }catch (DataIntegrityViolationException e){
            System.out.println(e.getMostSpecificCause().getMessage());
        }
        return null;
    }
}
