package comAula30Hibernate.service;

import comAula30Hibernate.model.Treinador;
import comAula30Hibernate.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {

    @Autowired
    private TreinadorRepository repository;

    public void inserir(Treinador treinador) {
        repository.save(treinador);
    }
}
