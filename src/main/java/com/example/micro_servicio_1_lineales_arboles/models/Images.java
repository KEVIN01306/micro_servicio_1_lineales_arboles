package com.example.micro_servicio_1_lineales_arboles.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Images {
    
    @Id
    private String _id;
    private String registro_id;
    private String base64Data;

    public String get_id(){
        return this._id;
    }

    public String getRegistro_id() {
        return this.registro_id;
    }

    public void setRegistro_id(String newRegistro_id) {
        this.registro_id = newRegistro_id;
    }

    public String getImagen() {
        return this.base64Data;
    }

    public void setImagen(String newImagen){
        this.base64Data = newImagen;
    }
}
