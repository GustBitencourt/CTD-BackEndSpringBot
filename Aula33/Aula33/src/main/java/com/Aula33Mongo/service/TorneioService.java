package com.Aula33Mongo.service;

import com.Aula33Mongo.model.Torneio;
import com.Aula33Mongo.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneioService {

    private TorneioRepository torneioRepository;

    @Autowired
    public TorneioService(TorneioRepository torneioRepository) {
        this.torneioRepository = torneioRepository;
    }

    public Torneio guardarTorneio(Torneio torneio) {
        return torneioRepository.save(torneio);
    }

    public List<Torneio> listarTorneios() {
        return torneioRepository.findAll();
    }




}
