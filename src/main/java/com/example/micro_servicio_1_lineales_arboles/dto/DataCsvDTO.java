package com.example.micro_servicio_1_lineales_arboles.dto;

import lombok.Data;

@Data
public class DataCsvDTO {

    private String type;
    private String operation;
    private Integer value;

    public DataCsvDTO(){

    }

    public DataCsvDTO(String newType, String newOperation, Integer newValue){
        this.type = newType;
        this.operation = newOperation;
        this.value = newValue;
    }

}
