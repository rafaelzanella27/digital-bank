package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.AtualizaContaEntity;
import com.lab.digitalbank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    PersistUpdateContaService persistUpdateContaService;

    @Autowired
    ListaContaPorIdService listaContaPorIdService;

    @Autowired
    ContaRepository contaRepository;

    public Map<String, Object> listarCliente(Integer id){
        return listaContaPorIdService.execute(id);
    }

//    public String deletar(Integer id){
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        if (cliente.isEmpty()){
//            return "Cliente inexistente";
//        }
//        clienteRepository.delete(cliente.get());
//        return "Cliente deletado com sucesso!";
//    }
//
    public String atualizarConta(Integer numero, Map<String, Object> contaDTO){
        Optional<Conta> conta = contaRepository.findById(numero);
        if (conta.isEmpty()){
            return "Conta inexistente";
        }
        AtualizaContaEntity atualizaContaEntity = AtualizaContaEntity.inicializa(contaDTO, conta.get());
        return persistUpdateContaService.execute(atualizaContaEntity);
    }


}
