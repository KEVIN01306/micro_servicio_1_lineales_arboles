package com.example.micro_servicio_1_lineales_arboles.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Registros {
    
    @Id
    private String id;
    private String date;
    private String changes;
    private String type;

    public String getId(){
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String newDate){
        this.date = newDate;
    }

    public String getChanges() {
        return this.changes;
    }

    public void setChanges(String newChanges){
        this.changes = newChanges; 
    }

    public String getType(){
        return this.type;
    }

    public void setType(String newType){
        this.type = newType; 
    }
    

}
