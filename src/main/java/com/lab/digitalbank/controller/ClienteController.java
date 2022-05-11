package com.lab.digitalbank.controller;

import com.lab.digitalbank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @PostMapping("/cliente/novoCliente")
    public ResponseEntity novoCliente(@RequestBody Map<String, Object> clienteDTO){
        Map<String, Object> response = this.clienteService.execute(clienteDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
