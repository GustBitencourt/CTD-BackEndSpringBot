package controller;

import domain.Paciente;
import service.OdontoService;

import java.util.Map;

@RestController
public class OdontoController {

    private OdontoService service;

    @GetMapping("listar")
    public Map<Integer, Paciente> buscarPaciente() {
        return service.buscarPaciente();
    }

    @GetMapping("criar")
    public Map<Integer, Paciente> criarPaciente() {
        return service.criarPaciente();
    }

    @GetMapping("deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id) {
        service.deletar(id);

        return "Paciente deletado";
    }


}
