package com.lab.digitalbank.controller;

import com.lab.digitalbank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;


    @GetMapping("/conta/listarPorIdCliente/{id}")
    public ResponseEntity listarContasPorIdCliente(@PathVariable("id") Integer id){
    Map<String, Object> cliente = this.contaService.listarCliente(id);
    return new ResponseEntity(cliente, HttpStatus.OK);
    }

//    @DeleteMapping("/cliente/deletar/{id}")
//    public ResponseEntity deletarCliente(@PathVariable("id") Integer id){
//        String response = this.clienteService.deletar(id);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//    @PutMapping("/cliente/atualizar/{id}")
//    public ResponseEntity atualizarCliente(@PathVariable("id") Integer id, @RequestBody Map<String, Object> clienteDTO){
//        String response = this.clienteService.atualizarCliente(id, clienteDTO);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
}
