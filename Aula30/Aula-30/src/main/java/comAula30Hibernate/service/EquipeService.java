package comAula30Hibernate.service;

import comAula30Hibernate.model.Equipe;
import comAula30Hibernate.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;

    //inserir
    public void inserir(Equipe equipe) {
        repository.save(equipe);
    }
}
