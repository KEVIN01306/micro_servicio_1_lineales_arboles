package com.example.micro_servicio_1_lineales_arboles.controllers;

import com.example.micro_servicio_1_lineales_arboles.services.ejemploService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EjemploController {

    @Autowired
    private ejemploService ejemploService;

    @GetMapping("/traerejemplo")
    public String traerejemplo(){
        return ejemploService.obtenerMensajeEjemplo();
    }


}

