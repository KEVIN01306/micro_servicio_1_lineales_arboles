package com.example.micro_servicio_1_lineales_arboles.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_servicio_1_lineales_arboles.dto.RegistroDTO;
import com.example.micro_servicio_1_lineales_arboles.services.RegistroService;

@RestController
@RequestMapping("/api/registros")
@CrossOrigin
public class RegistroController {

    private final RegistroService registroService;

    @Autowired
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping(value = "/obtenerTodosLosRegistros")
    public ResponseEntity<List<RegistroDTO>> obtenerTodosLosRegistros() {
        List<RegistroDTO> registros = registroService.getAllRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @PostMapping("/buscarPorId")
    public ResponseEntity<RegistroDTO> obtenerRegistroPorIdFromBody(@RequestBody Map<String, String> requestBody) {
        String id = requestBody.get("iden");
        RegistroDTO registro = registroService.getRegistroById(id);
        if (registro != null) {
            return new ResponseEntity<>(registro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}



