package com.oracle_alura.scream_match.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConverterDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
       try{
        return mapper.readValue(json, classe);
       }catch(JsonProcessingException e){
        throw new RuntimeException();
       }
    }

    
}
