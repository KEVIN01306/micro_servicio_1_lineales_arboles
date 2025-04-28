package com.example.micro_servicio_1_lineales_arboles.dto;



public class ImagesDTO {
    
    private String registro_id;
    private String imagen;

    public ImagesDTO(){

    }

    public ImagesDTO(String newRegistro_id, String newImagen) {
        this.registro_id = newRegistro_id;
        this.imagen = newImagen;
    }

    public String getRegistro_Id() {
        return this.registro_id;
    }

    public void setRegistro_Id(String newRegistro_Id) {
        this.registro_id = newRegistro_Id;
    }

    public String getImagen(){
        return this.imagen;
    }

    public void setImagen(String newImagen){
        this.imagen = newImagen;
    }
}
