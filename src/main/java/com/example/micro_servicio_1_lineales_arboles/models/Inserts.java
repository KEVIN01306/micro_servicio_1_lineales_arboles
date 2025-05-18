package com.example.micro_servicio_1_lineales_arboles.models;

import com.example.micro_servicio_1_lineales_arboles.dto.ImagesDTO;
import com.example.micro_servicio_1_lineales_arboles.dto.RegistroDTO;

import lombok.Data;

@Data
public class Inserts {
    
    private RegistroDTO registroDTO;
    private ImagesDTO imagesDTO;

    public Inserts(RegistroDTO newRegistro, ImagesDTO newImages){
        this.registroDTO = newRegistro;
        this.imagesDTO = newImages;
    }

    
}
