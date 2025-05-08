package com.example.micro_servicio_1_lineales_arboles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    private final ProcessDataService processDataService;

    @Autowired
    public CsvService(ProcessDataService processDataService) {
        this.processDataService = processDataService;
    }
    

    public List<CsvResponse> processCsvFile(MultipartFile file) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> fields = Arrays.asList(line.split(",")); 
                data.add(fields);
            }
        }

        
        return this.processDataService.cleanData(data);
    }

    
}