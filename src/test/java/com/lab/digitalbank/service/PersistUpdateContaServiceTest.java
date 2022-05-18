package com.lab.digitalbank.service;

import com.lab.digitalbank.domain.Conta;
import com.lab.digitalbank.entity.AtualizaContaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersistUpdateContaServiceTest {

    @Mock
    SaveContaService saveContaService;

    @InjectMocks
    PersistUpdateContaService persistUpdateContaService;

    @Test
    @DisplayName("DEVE receber objeto pela entity, atualizar e enviar para service de persistencia")
    public void testExecute(){
        AtualizaContaEntity atualizaContaEntityMock = Mockito.mock(AtualizaContaEntity.class);
        Mockito.when(atualizaContaEntityMock.geraSaida()).thenReturn(new Conta());
        this.persistUpdateContaService.execute(atualizaContaEntityMock);

        Mockito.verify(this.saveContaService, Mockito.times(1)).execute(Mockito.any(Conta.class));

        Assertions.assertEquals("Conta atualizada com sucesso", this.persistUpdateContaService.execute(atualizaContaEntityMock));
    }
}
