package com.example.micro_servicio_1_lineales_arboles.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageGenerationResponse {

    private String status;
    private List<String> generatedFiles;
}