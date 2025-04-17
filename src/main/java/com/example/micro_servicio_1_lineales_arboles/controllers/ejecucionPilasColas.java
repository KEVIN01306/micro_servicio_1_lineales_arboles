package com.example.micro_servicio_1_lineales_arboles.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajustes/pilas")
@CrossOrigin(origins = "*")
public class ejecucionPilasColas {
    

    @GetMapping("/estraerajustes")
    public String estraerajustes(){
        return "Obtener comple";
    }
}
