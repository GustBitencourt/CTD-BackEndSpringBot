package com.Aula34Integradora.services;

import com.Aula34Integradora.entities.Estado;
import com.Aula34Integradora.entities.Pacote;
import com.Aula34Integradora.repositories.PacoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {

    private PacoteRepository pacoteRepository;

    public PacoteService(PacoteRepository pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }

    public Pacote adicionar(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public List<Pacote> listar() {
        return pacoteRepository.findAll();
    }

    public List<Pacote> pacoteACaminho() {
        return pacoteRepository.findAllByEstado(Estado.ACAMINHO);
    }


}
