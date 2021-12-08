package com.Aula28Integradora.service;

import com.Aula28Integradora.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    //obter todos
    List<Produto> obterTodos();

    //obter por id
    Optional<Produto> buscar(Integer id);

    //salvar
    void guardar(Produto produto);

    //apagar
    void apagar(Integer id);

    //Atualizar
    Produto atualizar(Produto produto);


}
