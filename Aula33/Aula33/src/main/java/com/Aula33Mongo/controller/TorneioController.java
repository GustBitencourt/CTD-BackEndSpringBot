package com.Aula33Mongo.controller;

import com.Aula33Mongo.model.Torneio;
import com.Aula33Mongo.service.TorneioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    private TorneioService torneioService;

    @Autowired
    public TorneioController(TorneioService torneioService) {
        this.torneioService = torneioService;
    }

    @PostMapping
    public Torneio adicionarTorneio(@RequestBody Torneio torneio) {
        return torneioService.guardarTorneio(torneio);
    }

    @GetMapping
    public List<Torneio> listarTorneios() {
        return torneioService.listarTorneios();
    }
}
