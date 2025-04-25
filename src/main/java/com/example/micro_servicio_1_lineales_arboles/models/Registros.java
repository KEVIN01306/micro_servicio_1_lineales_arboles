package com.example.micro_servicio_1_lineales_arboles.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Registros {
    
    @Id
    private String _id;
    private String iden;
    private String date;
    private String changes;
    private String type;

    public String get_Id(){
        return this._id;
    }

    public String getId(){
        return this.iden;
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

}
