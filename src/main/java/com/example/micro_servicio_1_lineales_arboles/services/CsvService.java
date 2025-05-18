package com.example.micro_servicio_1_lineales_arboles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.micro_servicio_1_lineales_arboles.config.UtilitisConfig;
import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private UtilitisConfig utilitiesConfig;

    @Autowired
    private AlgorithmService algorithmService; 


    public List<CsvResponse> processCsvFile(MultipartFile file) throws IOException {
        
        List<CsvResponse> data = this.modulData(file);
        
        
        return algorithmService.executeAlgorithm(data);
    }

    public List<CsvResponse> modulData(MultipartFile file) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> fields = Arrays.asList(line.split(","));
                data.add(fields);
            }
        }

        return this.cleanData(data);
    }

    public List<CsvResponse> cleanData(List<List<String>> data) {
        List<CsvResponse> response = new ArrayList<>();

        for (List<String> registro : data) {
            if (!validaciones(registro)) {
                continue;
            }
            
            CsvResponse registroClean = new CsvResponse(this.utilitiesConfig.translate(registro.get(0)), registro.get(1), registro.get(2));

            response.add(registroClean);
        }

        return response;
    }

    public boolean validaciones(List<String> crudData) {
        if (crudData == null || crudData.size() != 3) {
            return false;
        }

        if (crudData.get(2).trim().isBlank() && !utilitiesConfig.ListaOperations().get(1).equals(crudData.get(1))) {
            return false;
        }

        if (!utilitiesConfig.ListaTypes().contains(crudData.get(0))) {
            return false;
        }

        if (!utilitiesConfig.ListaOperations().contains(crudData.get(1))) {
            return false;
        }

        return true;
    }


}