package com.example.micro_servicio_1_lineales_arboles.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.config.UtilitisConfig;
import com.example.micro_servicio_1_lineales_arboles.dto.ImagesDTO;
import com.example.micro_servicio_1_lineales_arboles.dto.RegistroDTO;
import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;
import com.example.micro_servicio_1_lineales_arboles.models.Inserts;

@Service
public class AlgorithmService {

    @Autowired
    private UtilitisConfig utilitiesConfig;

        @Autowired
    private CreateImageService createImageService;


    public List<CsvResponse>  executeAlgorithm(List<CsvResponse> data){
        List<CsvResponse> response = new ArrayList<>();
        for ( String type: utilitiesConfig.ListaTypes()){
            response = filterForType(data,utilitiesConfig.translate(type));

            if (!response.isEmpty()){
                continue;
            }




        }

        return response;
    }

    public List<CsvResponse> filterForType(List<CsvResponse> listaData, String filter) {
        List<CsvResponse> dataFilter = new ArrayList<>();

        for (CsvResponse objetoData : listaData) {
            if (filter.equals(objetoData.getType())) {
                dataFilter.add(objetoData);
            }
        }

        return dataFilter;
    }

    public void executeAlgorithmForType(List<CsvResponse> data, String type){

        Inserts insert;
        List<String> changes = new ArrayList<>();

        if (!data.isEmpty()){
            return;
        }
        for (CsvResponse lineData: data){
            if (utilitiesConfig.translate(type).equals(utilitiesConfig.ListaTypes().get(0))){
                changes = algorithmStack(changes, lineData);
            }else if(utilitiesConfig.translate(type).equals(utilitiesConfig.ListaTypes().get(1))){
                changes = algorithmQueue(changes, lineData);
            }

        }
    }
    
    public List<String> algorithmStack(List<String> changes,CsvResponse line){
        List<String> newChanges = changes;
        if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(0))){
            newChanges.add(line.getValor());
        } else if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(1))){
            newChanges.remove(newChanges.size() -1);
        }

        return newChanges;
    }

    public List<String> algorithmQueue(List<String> changes,CsvResponse line){
        List<String> newChanges = changes;
        if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(0))){
            newChanges.add(line.getValor());
        } else if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(1))){
            newChanges.remove(0);
        }
        
        return newChanges;
    }

}
