package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.ConsultaContaEntity;
import com.lab.digitalbank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListaContaPorIdService {

    @Autowired
    ContaRepository contaRepository;

    public Map<String, Object> execute(Integer id){
        List<Conta> conta = contaRepository.findAllByIdClient(id);
        return retornaContasEncontradas(conta);
    }

    private Map<String, Object> retornaContasEncontradas(List<Conta> conta){
        if (conta.isEmpty()){
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("error", "Conta não encontrada");
            return errorMap;
        }
        return ConsultaContaEntity.inicializa(conta).geraSaida();
    }
}
