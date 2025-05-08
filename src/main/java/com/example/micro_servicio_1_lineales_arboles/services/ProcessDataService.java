package com.example.micro_servicio_1_lineales_arboles.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.config.UtilitisConfig;
import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;

@Service
public class ProcessDataService {


    @Autowired
    private UtilitisConfig utilitiesConfig;
    
    public List<CsvResponse> cleanData(List<List<String>> data){
        List<CsvResponse> response = new ArrayList<>();

        for (List<String> registro : data) {
            if (!validaciones(registro)){
                continue;
            }

            CsvResponse registroClean = new CsvResponse(registro.get(0),registro.get(1),registro.get(2));

            response.add(registroClean);
        }

        return response;
    }

    public boolean validaciones(List<String> crudData){
        if (crudData == null || crudData.size() !=3 ){
            return false;
        }

        if (crudData.get(2).trim().isBlank()){
            return false;
        }

        if ( !utilitiesConfig.ListaTypes().contains(crudData.get(0)) ){
            return false;
        }

        if (!utilitiesConfig.ListaOperations().contains(crudData.get(1))){
            return false;
        }

        return true;
    }


}
