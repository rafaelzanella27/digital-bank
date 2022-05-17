package com.lab.digitalbank.entity.adapter;

import com.lab.digitalbank.domain.Conta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ContaToDtoAdapter {

    public Map<String, Object> converte(List<Conta> conta){
        Map<String, Object> contasDto = new HashMap<>();
        if (Objects.nonNull(conta)){
            contasDto.put("Contas", conta);
        }
        return contasDto;
    }
}
