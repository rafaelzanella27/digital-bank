package com.lab.digitalbank.controller;

import com.lab.digitalbank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @PostMapping("/cliente/novoCliente")
    public ResponseEntity novoCliente(@RequestBody Map<String, Object> clienteDTO){
        Map<String, Object> response = this.clienteService.salvar(clienteDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/cliente/listar/{id}")
    public ResponseEntity listarCliente(@PathVariable("id") Long id){
    Map<String, Object> cliente = this.clienteService.listarCliente(id);
    return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/cliente/deletar/{id}")
    public ResponseEntity deletarCliente(@PathVariable("id") Long id){
        String response = this.clienteService.deletar(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/cliente/atualizar/{id}")
    public ResponseEntity atualizarCliente(@PathVariable("id") Long id, @RequestBody Map<String, Object> clienteDTO){
        String response = this.clienteService.atualizarCliente(id, clienteDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
