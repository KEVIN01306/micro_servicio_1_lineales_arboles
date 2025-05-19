package com.example.micro_servicio_1_lineales_arboles.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.config.UtilitisConfig;
import com.example.micro_servicio_1_lineales_arboles.dto.ImagesDTO;
import com.example.micro_servicio_1_lineales_arboles.dto.RegistroDTO;
import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;
import com.example.micro_servicio_1_lineales_arboles.models.Images;

@Service
public class AlgorithmService {

    @Autowired
    private UtilitisConfig utilitiesConfig;

    @Autowired
    private CreateImageService createImageService;

    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private ImagesService imagesService;

    public List<CsvResponse>  executeAlgorithm(List<CsvResponse> data){
        List<CsvResponse> response = new ArrayList<>();
        for ( String type: utilitiesConfig.ListaTypes()){
            response = filterForType(data,utilitiesConfig.translate(type));

            if (response.isEmpty()){
                continue;
            }

            this.executeAlgorithmForType(response,type);
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

        List<String> changesList = new ArrayList<>();
        Integer changes = 0;
        List<ImagesDTO> imagesList = new ArrayList<ImagesDTO>();

        if (data.isEmpty()){
            return;
        }
        for (CsvResponse lineData: data){
            if (utilitiesConfig.translate(type).equals(utilitiesConfig.translate(utilitiesConfig.ListaTypes().get(0)))){
                changesList = algorithmStack(changesList,lineData);
            }else if(utilitiesConfig.translate(type).equals(utilitiesConfig.translate(utilitiesConfig.ListaTypes().get(1)))){
                changesList = algorithmQueue(changesList, lineData);
            }

            System.out.println("Operacion recibida: " + lineData.getType());
            System.out.println("Operacion esperada: " + utilitiesConfig.ListaTypes().get(0));
            System.out.println("Lista completa de operaciones: " + utilitiesConfig.ListaOperations());

            ImagesDTO imageDto = new ImagesDTO();
            imageDto.setRegistro_Id("0");
            System.out.println(changesList);
            try {
                imageDto.setImagen(createImageService.generateListImageBase64(changesList));
                imagesList.add(imageDto);
            } catch (IOException e) {
                System.err.println("Error al generar la imagen Base64 para la lista " + changes + ": " + e.getMessage());
            }
            changes ++;
        }

        RegistroDTO registroDto = new RegistroDTO();
        registroDto.setDate(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ISO_DATE));
        registroDto.setChanges(String.valueOf(changes));
        registroDto.setType(utilitiesConfig.translate(type));

        RegistroDTO registroGuardadoDto = this.registroService.guardarRegistro(registroDto);

        for (ImagesDTO imagen: imagesList){
            imagen.setRegistro_Id(registroGuardadoDto.getId());
            this.imagesService.saveImage(imagen);
        }
    }
    
    public List<String> algorithmStack(List<String> changes,CsvResponse line){
        List<String> newChanges = changes;
        if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(0))){
            newChanges.add(line.getValor());
        } else if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(1)) && !newChanges.isEmpty()){
            newChanges.remove(newChanges.size() -1);
        }
        return newChanges;
    }

    public List<String> algorithmQueue(List<String> changes,CsvResponse line){
        List<String> newChanges = changes;
        if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(0))){
            newChanges.add(line.getValor());
        } else if (line.getOperacion().equals(utilitiesConfig.ListaOperations().get(1)) && !newChanges.isEmpty()){
            newChanges.remove(0);
        }
        return newChanges;
    }

}
