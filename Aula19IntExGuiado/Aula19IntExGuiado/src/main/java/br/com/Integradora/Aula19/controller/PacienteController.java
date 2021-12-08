package br.com.Integradora.Aula19.controller;

import br.com.Integradora.Aula19.domain.Paciente;
import br.com.Integradora.Aula19.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaremail")
    public String busca(Model model) {
        Paciente pac = pacienteService.buscaPorEmail(
                "cassio@corinthians.com"
        );
        model.addAttribute("nome", pac.getNome());
        model.addAttribute("sobrenome", pac.getSobrenome());
        return "index";
    }
}
