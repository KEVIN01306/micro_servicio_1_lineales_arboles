package com.example.micro_servicio_1_lineales_arboles.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.micro_servicio_1_lineales_arboles.models.Images;



@Repository
public interface ImageRepository extends MongoRepository <Images, String> {
    
    @Query("{ 'registro_id': ?0 }")
    List<Images> findAllByImages( String registro_id );
}
