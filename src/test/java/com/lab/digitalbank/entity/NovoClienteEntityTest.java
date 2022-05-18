package com.lab.digitalbank.entity;

import com.lab.digitalbank.domain.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NovoClienteEntityTest {

    @Test
    @DisplayName("DEVE testar função incializa com dados válidos")
    public void testInicializa(){
        NovoClienteEntity novoClienteEntity = NovoClienteEntity.inicializa(new HashMap<>());
        Assertions.assertNotNull(novoClienteEntity);
    }

    @Test
    @DisplayName("DEVE testar função geraSaida com dados válidos")
    public void testGeraSaida(){
        Map<String, Object> entrada = new HashMap<>();
        Map<String, Object> clienteMap = new HashMap<>();
        clienteMap.put("nome", "Maria");
        entrada.put("cliente", clienteMap);
        Cliente cliente = NovoClienteEntity.inicializa(entrada).geraSaida();
        Assertions.assertNotNull(cliente);
        Assertions.assertEquals("Maria", cliente.getNome());
    }

    @Test
    @DisplayName("DEVE testar função possuiContas com valor verdadeiro")
    public void testPossuiContas(){
        Map<String, Object> entrada = new HashMap<>();
        Map<String, Object> clienteMap = new HashMap<>();
        Map<String, Object> contasMap = new HashMap<>();
        clienteMap.put("nome", "Maria");
        entrada.put("cliente", clienteMap);
        entrada.put("contas", contasMap);
        Boolean resultado = NovoClienteEntity.inicializa(entrada).possuiContas();
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("DEVE testar função possuiContas com valor falso")
    public void testPossuiContasComValorFalso(){
        Map<String, Object> entrada = new HashMap<>();
        Map<String, Object> clienteMap = new HashMap<>();
        clienteMap.put("nome", "Maria");
        entrada.put("cliente", clienteMap);
        Boolean resultado = NovoClienteEntity.inicializa(entrada).possuiContas();
        Assertions.assertFalse(resultado);
    }
}
