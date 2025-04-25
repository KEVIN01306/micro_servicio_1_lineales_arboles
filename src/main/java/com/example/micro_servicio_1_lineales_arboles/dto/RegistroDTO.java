package com.example.micro_servicio_1_lineales_arboles.dto;

public class RegistroDTO {
    
    private String id;
    private String date;
    private String changes;
    private String type;

    public RegistroDTO(){

    }

    public RegistroDTO(String newId, String newDate, String newChanges, String newType){
        this.id = newId;
        this.date = newDate;
        this.changes = newChanges;
        this.type = newType;
    }

    public String getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getChanges() {
        return this.changes;
    }

    public String getType() {
        return this.type;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setDate(String newDate) {
        this.date = newDate;
    }

    public void setChanges(String newChanges) {
        this.changes = newChanges;
    }

    public void setType(String newType) {
        this.type = newType;
    }

}
