package com.example.micro_servicio_1_lineales_arboles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_servicio_1_lineales_arboles.dto.ImagesDTO;
import com.example.micro_servicio_1_lineales_arboles.services.ImagesService;

@RestController
@RequestMapping("/api/imagenes")
@CrossOrigin(origins = "*")
public class ImagesController {
    
    private final ImagesService imagesService;

    @Autowired
    public ImagesController(ImagesService imagesService){
        this.imagesService = imagesService;
    }

    @GetMapping(value = "obtenerTodasLasImagenes")
    public ResponseEntity<List<ImagesDTO>> obtenerTodasLasImagenes(){
        List<ImagesDTO> imagenes = imagesService.getAllImages();
        return new ResponseEntity<>(imagenes,HttpStatus.OK);
    }

}
