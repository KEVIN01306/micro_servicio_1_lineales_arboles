package com.example.micro_servicio_1_lineales_arboles.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.micro_servicio_1_lineales_arboles.models.Registros;

@Repository
public interface RegistroRepository extends MongoRepository<Registros, String>{

    @Query("{ 'iden': ?0 }")
    Optional<Registros> findOneByIdenQuery( String iden);
    
}
