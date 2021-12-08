package br.com.Integradora.Aula19.service;

import br.com.Integradora.Aula19.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPacienteService {

    List<Paciente> listPaciente();
    Paciente buscaPorEmail(String email);
}
