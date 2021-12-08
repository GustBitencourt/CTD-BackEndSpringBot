package com.Aula28Integradora.service;

import com.Aula28Integradora.dao.ProdutoRepository;
import com.Aula28Integradora.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Obter Todos
    @Override
    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    //Buscar por Id
    @Override
    public Optional<Produto> buscar(Integer id) {
        return produtoRepository.findById(id);
    }

    //Salvar
    @Override
    public void guardar(Produto produto) {
        produtoRepository.save(produto);
    }

    //Apagar
    @Override
    public void apagar(Integer id) {
        produtoRepository.deleteById(id);
    }

    //Atualizar
    @Override
    public Produto atualizar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
