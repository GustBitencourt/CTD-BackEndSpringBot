package comAula30Hibernate.service;

import comAula30Hibernate.dao.JogadorDAO;
import comAula30Hibernate.model.Equipe;
import comAula30Hibernate.model.Jogador;
import comAula30Hibernate.model.Treinador;
import comAula30Hibernate.repository.EquipeRepository;
import comAula30Hibernate.repository.JogadorRepository;
import comAula30Hibernate.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;
    @Autowired
    private TreinadorRepository treinadorRepository;
    @Autowired
    private EquipeRepository equipeRepository;

    public void inserir(JogadorDAO jogadorDAO){
        Treinador treinador_id = treinadorRepository.getById(jogadorDAO.getIdTreinador());
        Equipe equipe_id = equipeRepository.getById(jogadorDAO.getIdEquipe());
        Jogador jogador = new Jogador(
                jogadorDAO.getNome(),
                jogadorDAO.getPosicao(),
                jogadorDAO.getNumero(),
                equipe_id,
                treinador_id);
    }
}
