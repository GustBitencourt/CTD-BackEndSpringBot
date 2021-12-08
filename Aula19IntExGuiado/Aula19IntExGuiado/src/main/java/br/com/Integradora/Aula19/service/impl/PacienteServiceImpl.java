package br.com.Integradora.Aula19.service.impl;

import br.com.Integradora.Aula19.domain.Endereco;
import br.com.Integradora.Aula19.domain.Paciente;
import br.com.Integradora.Aula19.service.IPacienteService;
import br.com.Integradora.Aula19.util.UtilDate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    private Endereco end1 = new Endereco(
            "Rua Borbolestas Psicodélicas", "123", "São Paulo", "SP");

    private Paciente pac1 = new Paciente(
            1, "Cassio", "Corinthians", "cassio@corinthians.com", "1234", UtilDate.dateToTimestamp(new Date()), end1);

    private Endereco end2 = new Endereco(
            "Ladeira do Acupe", "321", "Salvador", "BA");

    private Paciente pac2 = new Paciente(
            2, "Gilberto", "Bahia", "gilberto@bahia.com", "4321", UtilDate.dateToTimestamp(new Date()), end2);


    @Override
    public List<Paciente> listPaciente() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(pac1);
        pacientes.add(pac2);

        return pacientes;
    }

    @Override
    public Paciente buscaPorEmail(String email) {
        if (email.equalsIgnoreCase(pac1.getEmail()))
            return pac1;
        else if (email.equalsIgnoreCase(pac2.getEmail()))
            return pac2;

        return null;
    }
}
