package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Cliente;
import com.lab.digitalbank.entity.AtualizaClienteEntity;
import com.lab.digitalbank.entity.NovoClienteEntity;
import com.lab.digitalbank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    PersistCreateService persistCreateService;

    @Autowired
    PersistUpdateClienteService persistUpdateClienteService;

    @Autowired
    ListaClientePorIdService listaClientePorIdService;

    @Autowired
    ClienteRepository clienteRepository;

    public Map<String, Object> salvar(Map<String, Object> clienteDTO){
        try {
            NovoClienteEntity novoClienteEntity = NovoClienteEntity.inicializa(clienteDTO);
            return persistCreateService.execute(novoClienteEntity);
        }catch (RuntimeException e){
            e.getMessage();
        }
        return null;
    }

    public Map<String, Object> listarCliente(Integer id){
        return listaClientePorIdService.execute(id);
    }

    public String deletar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            return "Cliente inexistente";
        }
        try {
            clienteRepository.delete(cliente.get());
        } catch (Exception e){
            return "Não é possível deletar um cliente com uma conta vinculada.";
        }
        return "Cliente deletado com sucesso!";
    }

    public String atualizarCliente(Integer id, Map<String, Object> clienteDTO){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            return "Cliente inexistente";
        }
        AtualizaClienteEntity atualizaClienteEntity = AtualizaClienteEntity.inicializa(clienteDTO, cliente.get());
        return persistUpdateClienteService.execute(atualizaClienteEntity);
    }


}
