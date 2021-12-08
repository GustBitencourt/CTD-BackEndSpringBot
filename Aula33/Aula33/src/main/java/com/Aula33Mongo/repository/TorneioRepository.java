package com.Aula33Mongo.repository;

import com.Aula33Mongo.model.Torneio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends MongoRepository<Torneio, String> {


}
