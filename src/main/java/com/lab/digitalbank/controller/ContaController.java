package com.lab.digitalbank.controller;

import com.lab.digitalbank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/conta/deletar/{numero}")
    public ResponseEntity deletarConta(@PathVariable("numero") Integer numero){
        String response = this.contaService.deletar(numero);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/conta/atualizar/{numero}")
    public ResponseEntity atualizarConta(@PathVariable("numero") Integer numero, @RequestBody Map<String, Object> contaDTO){
        String response = this.contaService.atualizarConta(numero, contaDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
