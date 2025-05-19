package com.example.micro_servicio_1_lineales_arboles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_servicio_1_lineales_arboles.dto.RegistroDTO;
import com.example.micro_servicio_1_lineales_arboles.models.Registros;
import com.example.micro_servicio_1_lineales_arboles.repository.RegistroRepository;

@Service
public class RegistroService {
    

    private final RegistroRepository registroRepository;

    @Autowired
    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<RegistroDTO> getAllRegistros() {
        List<Registros> registros = registroRepository.findAll();
        return registros.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RegistroDTO getRegistroById(String id){
        Registros registro = registroRepository.findById(id).orElse(null);
        return registro != null ? convertToDTO(registro) : null;
    }

    public List<RegistroDTO> getRegistroByType(String type) {
        List<Registros> registros = registroRepository.findAllByType(type);
        return registros.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RegistroDTO guardarRegistro(RegistroDTO registroDTO) {
        Registros registro = convertToEntity(registroDTO);
        Registros registroGuardado = registroRepository.save(registro);
        return convertToDTO(registroGuardado);
    }

    private RegistroDTO convertToDTO(Registros registro) {
        RegistroDTO registroDTO = modelMapper.map(registro, RegistroDTO.class);
        registroDTO.setId(registro.getId());
        registroDTO.setDate(registro.getDate());
        registroDTO.setChanges(registro.getChanges());
        registroDTO.setType(registro.getType());
        return registroDTO;
    }

    private Registros convertToEntity(RegistroDTO registroDTO) {
        return modelMapper.map(registroDTO, Registros.class);
    }

}
