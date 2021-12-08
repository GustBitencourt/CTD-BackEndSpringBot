package com.Aula34Integradora.controllers;

import com.Aula34Integradora.entities.Pacote;
import com.Aula34Integradora.exceptions.BadRequestException;
import com.Aula34Integradora.repositories.PacoteRepository;
import com.Aula34Integradora.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private PacoteService pacoteService;
    private PacoteRepository pacoteRepository;

    @Autowired
    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @PostMapping
    public Pacote adicionar(@RequestBody Pacote pacote) throws BadRequestException {

        if(pacoteRepository.findByCodigo(pacote.getCodigo()).isEmpty()){
            return pacoteService.adicionar(pacote);
        } else {
            
            throw new BadRequestException("Já existe pacote com esse código!");
        }
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processarErrosBadRequest(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @GetMapping("/lista")
    public List<Pacote> listar() {
        return pacoteService.listar();
    }

    @GetMapping("/acaminho")
    public List<Pacote> aCaminho() {
        return pacoteService.pacoteACaminho();
    }




    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<String> processErrorBadRequest(BadRequestException error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
    }


}
