package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService{

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista cadastrar(Dentista dentista) {
        dentistaIDao.cadastrar(dentista);
        return dentista;
    }

    public Optional<Dentista> buscar(Integer id) {
        return dentistaIDao.buscar(id);
    }

    public List<Dentista> buscarTodos() {
        return dentistaIDao.buscarTodos();
    }

    public void excluir(Integer id) {
        dentistaIDao.excluir(id);
    }

    public Dentista atualizar (Dentista dentista){
        return dentistaIDao.atualizar(dentista);
    }
}

/*private Dentista dentista1 = new Dentista(
            1,
            "Zusé",
            "da Silva",
            "123456");

    private Dentista dentista2 = new Dentista(
            2,
            "Zuséfino",
            "da Mata",
            "123321"); */

    /*@Override
    public List<Dentista> listDentista(){
        ArrayList<Dentista> dentista = new ArrayList<>();
        dentista.add(dentista1);
        dentista.add(dentista2);
        return dentista;*/
