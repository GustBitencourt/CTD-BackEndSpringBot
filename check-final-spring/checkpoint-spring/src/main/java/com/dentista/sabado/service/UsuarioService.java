package com.dentista.sabado.service;

import com.dentista.sabado.model.Usuario;
import com.dentista.sabado.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private IDao<Usuario> usuarioDao;

    public UsuarioService(IDao<Usuario> dentistaDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDao.salvar(usuario);
    }

    public void excluir(Integer id) {
        usuarioDao.excluir(id);
    }

    public Optional<Usuario> buscar(Integer id) {
        return usuarioDao.buscar(id);
    }

    public List<Usuario> buscarTodos() {
        return usuarioDao.buscarTodos();
    }

    public Usuario atualizar(Usuario usuario) {
        return  usuarioDao.atualizar(usuario);
    }


}
