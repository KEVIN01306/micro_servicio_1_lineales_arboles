package com.example.micro_servicio_1_lineales_arboles.models;

import lombok.Data;

@Data
public class CsvResponse {
    
    private String type;
    private String operacion;
    private String valor;
    
    
    public CsvResponse(String type, String operacion, String valor) {
        this.type = type;
        this.operacion = operacion;
        this.valor = valor;
    }

}
