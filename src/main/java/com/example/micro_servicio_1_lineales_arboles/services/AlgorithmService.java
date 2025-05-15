package com.example.micro_servicio_1_lineales_arboles.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;

@Service
public class AlgorithmService {

    public List<CsvResponse> filterForType(List<CsvResponse> listaData, String filter) {
        List<CsvResponse> dataFilter = new ArrayList<>();

        for (CsvResponse objetoData : listaData) {
            if (filter.equals(objetoData.getType())) {
                dataFilter.add(objetoData);
            }
        }

        return dataFilter;
    }
}
