package com.example.micro_servicio_1_lineales_arboles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.dto.ImagesDTO;
import com.example.micro_servicio_1_lineales_arboles.models.Images;
import com.example.micro_servicio_1_lineales_arboles.repository.ImageRepository;

@Service
public class ImagesService {
    
    private final ImageRepository imageRepository;

    @Autowired
    public ImagesService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Autowired
    private ModelMapper modelMapper;


    public List<ImagesDTO> getAllImages(){
        List<Images> imagenes = imageRepository.findAll();
        return imagenes.stream().map(this::converToDto).collect(Collectors.toList());
    }

    public ImagesDTO converToDto(Images imagen){
        ImagesDTO imagenDTO = modelMapper.map(imagen,ImagesDTO.class);
        imagenDTO.setRegistro_Id(imagen.getRegistro_id());
        imagenDTO.setImagen(imagen.getImagen());
        return imagenDTO;
    }


}
