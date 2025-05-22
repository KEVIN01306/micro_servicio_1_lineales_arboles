package com.example.micro_servicio_1_lineales_arboles.controllers;

import com.example.micro_servicio_1_lineales_arboles.models.CsvResponse;
import com.example.micro_servicio_1_lineales_arboles.services.CsvService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class upLoadCsvController {

    private final CsvService csvService;

    public upLoadCsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload-csv")
    public ResponseEntity<Map<String, String>> uploadCsvFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();

        if (!file.getOriginalFilename().toLowerCase().endsWith(".csv")) {
            response.put("message", "El archivo debe tener extensión .csv");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (file.isEmpty()) {
            response.put("message", "El archivo está vacío.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        try {
            List<CsvResponse> data = csvService.processCsvFile(file);
            if (data.isEmpty()) {
                response.put("message", "Error de tipos o comandos");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            response.put("message", "Data insertada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            response.put("message", "Error al procesar el archivo CSV.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}