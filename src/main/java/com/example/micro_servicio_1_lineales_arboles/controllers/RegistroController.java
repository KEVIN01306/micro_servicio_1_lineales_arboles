package com.example.micro_servicio_1_lineales_arboles.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/buscarPorId")
    public ResponseEntity<RegistroDTO> obtenerRegistroPorIdFromParam(@RequestParam("id") String id) {
        RegistroDTO registro = registroService.getRegistroById(id);
        if (registro != null) {
            return new ResponseEntity<>(registro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/buscarPorTipo")
    public ResponseEntity<List<RegistroDTO>> obtenerRegistroPortype(@RequestParam("type") String type){
        List<RegistroDTO> registro = registroService.getRegistroByType(type);
        if (registro != null) {
            return new ResponseEntity<>(registro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insertar")
    public ResponseEntity<RegistroDTO> insertarRegistro(@RequestBody RegistroDTO registroDTO) {
        RegistroDTO nuevoRegistro = registroService.guardarRegistro(registroDTO);
        return new ResponseEntity<>(nuevoRegistro, HttpStatus.CREATED);
    }

    
}



