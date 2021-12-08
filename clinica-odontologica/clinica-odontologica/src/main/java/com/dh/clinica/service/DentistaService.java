package com.dh.clinica.service;

import com.dh.clinica.dao.IDao;
import com.dh.clinica.model.Dentista;


import java.util.List;
import java.util.Optional;

public class DentistaService {

    private IDao<Dentista> dentistaDao;


    public DentistaService(IDao<Dentista> dentistaDao) {
        this.dentistaDao = dentistaDao;
    }

    public Dentista registrarDentista(Dentista dentista) {
        return dentistaDao.salvar(dentista);

    }

    public void remover(Integer id) {
        dentistaDao.remover(id);
    }

    public Optional<Dentista> buscar(Integer id) {
        return dentistaDao.buscar(id);
    }

    public List<Dentista> buscarTodos() {
        return dentistaDao.buscarTodos();
    }
}
