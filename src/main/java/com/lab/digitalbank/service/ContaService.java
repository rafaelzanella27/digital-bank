package com.lab.digitalbank.service;

import com.lab.digitalbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContaService {

    @Autowired
    PersistUpdateClienteService persistUpdateClienteService;

    @Autowired
    ListaContaPorIdService listaContaPorIdService;

    @Autowired
    ClienteRepository clienteRepository;


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
//    public String atualizarCliente(Integer id, Map<String, Object> clienteDTO){
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        if (cliente.isEmpty()){
//            return "Cliente inexistente";
//        }
//        AtualizaClienteEntity atualizaClienteEntity = AtualizaClienteEntity.inicializa(clienteDTO, cliente.get());
//        return persistUpdateClienteService.execute(atualizaClienteEntity);
//    }


}
