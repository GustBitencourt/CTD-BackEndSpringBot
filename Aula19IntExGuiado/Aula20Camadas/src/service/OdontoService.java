package service;

import domain.Paciente;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class OdontoService {

    private static Map<Integer, Paciente> nossoMapa = new HashMap<>();

    private String[] nomes = {
            "Gaspar", "Antonio", "Marta", "Bianca", "Patrick", "Nelson", "Carlindo", "Paula", "Ana", "Mila"
    };

    private String[] sobrenomes = {
            "Souza", "Santos", "Oliveira", "Silva", "Gomes", "Gama", "Macedo", "Diberto", "Aragão", "Braba"
    };

    public Paciente criarPaciente() {
        Random aleatorio = new Random();
        int upperbound = 10;
        String nome = nomes[aleatorio.nextInt(upperbound)];
        String sobrenome = sobrenomes[aleatorio.nextInt(upperbound)];
        String email = nome.toLowerCase() + sobrenome.toLowerCase() + "@dh.com";
        Integer id = nossoMapa.size() + 1;

        nossoMapa.put(id, new Paciente(nome, sobrenome, email, (aleatorio.nextInt(upperbound) + 18)));

        return nossoMapa.get(id);
    }

    public Map<Integer, Paciente> buscarPaciente() {
        return nossoMapa;
    }

    public void deletar(Integer id) {
        nossoMapa.remove(id);
    }
}
