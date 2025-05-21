package com.example.micro_servicio_1_lineales_arboles.config;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilitisConfig {
    
    @Bean
    public List<String> ListaTypes() {
        return Arrays.asList("pila","cola","arreglo");
    }

    @Bean
    public List<String> ListaOperations() {
        return Arrays.asList("insertar","eliminar");
    }
    
    
    public String translate(String base){
        if ("pila".equals(base)){
            return "stack";
        }
        if ("cola".equals(base)){
            return "queue";
        }
        if ("arreglo".equals(base)){
            return "array";
        }

        return base;
    }
}