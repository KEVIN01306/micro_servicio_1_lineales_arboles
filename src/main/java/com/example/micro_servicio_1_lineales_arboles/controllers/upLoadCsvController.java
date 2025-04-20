package com.example.micro_servicio_1_lineales_arboles.controllers;

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
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class upLoadCsvController {

    private final CsvService csvService;

    public upLoadCsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/upload-csv")
    public ResponseEntity<List<String[]>> uploadCsvFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<String[]> data = csvService.processCsvFile(file);
            return new ResponseEntity<>(data, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}