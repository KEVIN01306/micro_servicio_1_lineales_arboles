package com.example.micro_servicio_1_lineales_arboles.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EjemploController {

    @GetMapping("/traerejemplo")
    public String traerejemplo(){
        return "Hola PaPU";
    }


}

