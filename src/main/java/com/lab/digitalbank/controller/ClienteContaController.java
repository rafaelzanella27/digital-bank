package com.lab.digitalbank.controller;

import com.lab.digitalbank.service.ClienteContaService;
import com.lab.digitalbank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClienteContaController {

    @Autowired
    ClienteContaService clienteContaService;


    @PostMapping("/clienteConta/novoVincular")
    public ResponseEntity novoCliente(@RequestBody Map<String, Object> clienteContaDTO){
        Map<String, Object> response = this.clienteContaService.novo(clienteContaDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
