package com.Aula34Integradora.repositories;

import com.Aula34Integradora.entities.Estado;
import com.Aula34Integradora.entities.Pacote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacoteRepository extends MongoRepository<Pacote, String> {

    @Query
    List<Pacote> findByCodigo(String s);

    List<Pacote> findAllByEstado(Estado estado);







}
