package br.com.Integradora.Aula19.controller;

import br.com.Integradora.Aula19.domain.Paciente;
import br.com.Integradora.Aula19.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteControllerLista {

    private final IPacienteService iPacienteService;

    @Autowired
    public PacienteControllerLista(IPacienteService iPacienteService) {
        this.iPacienteService = iPacienteService;
    }

    @GetMapping("/listarpac")
    public List<Paciente> getPaciente() {
        return iPacienteService.listPaciente();
    }


}
