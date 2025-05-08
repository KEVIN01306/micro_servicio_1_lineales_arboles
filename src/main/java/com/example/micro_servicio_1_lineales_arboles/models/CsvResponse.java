package com.example.micro_servicio_1_lineales_arboles.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvResponse {
    
    private String type;
    private String operacion;
    private String valor;
}
