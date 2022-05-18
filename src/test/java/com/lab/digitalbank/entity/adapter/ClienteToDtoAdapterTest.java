package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ClienteToDtoAdapterTest {

    @Test
    @DisplayName("DEVE receber um objeto Cliente e converter para MAP")
    public void testConverte(){
        Cliente cliente = new Cliente();
        cliente.setNome("Joao");
        cliente.setId(1);

        Map<String, Object> mapResultado = new ClienteToDtoAdapter().converte(cliente);

        Assertions.assertNotNull(mapResultado);
        Assertions.assertEquals("Joao", mapResultado.get("nome"));
        Assertions.assertEquals(1, mapResultado.get("id"));
    }
}
