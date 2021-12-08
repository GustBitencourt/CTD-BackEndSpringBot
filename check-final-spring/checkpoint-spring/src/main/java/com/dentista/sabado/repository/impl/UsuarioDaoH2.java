package com.dentista.sabado.repository.impl;

import com.dentista.sabado.model.Usuario;
import com.dentista.sabado.repository.IDao;
import com.dentista.sabado.repository.config.ConfigDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDaoH2 implements IDao<Usuario> {

    private final ConfigDB configDB;

    public UsuarioDaoH2(ConfigDB configDB) {
        this.configDB = configDB;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        Connection connection = configDB.conectarComBancoDeDados();
        Statement statement = null;
        String querySalvar = String.format(
                "INSERT INTO usuario " +
                "(nome, sobrenome, matricula) " +
                "VALUES ('%s', '%s', '%s')",
            usuario.getNome(), usuario.getSobrenome(), usuario.getAcesso());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                usuario.setId(keys.getInt(1));
            }

            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Optional<Usuario> buscar(Integer id) {
        Connection connection = configDB.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscarOne = String.format(
                "SELECT id, nome, sobrenome, acesso " +
                "FROM usuario WHERE id = '%s', id");
        Usuario usuario = null;

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBuscarOne);

            while (result.next()) {
                usuario = criarObjetoUsuario(result);
            }
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configDB.conectarComBancoDeDados();
        Statement statement = null;
        String queryExcluir = String.format("DELETE FROM usuario WHERE id = '%s' ", id);
        execute(connection, queryExcluir);
    }

    @Override
    public List<Usuario> buscarTodos() {
        Connection connection = configDB.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscarAll = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBuscarAll);
            while (result.next()) {
                usuarios.add(criarObjetoUsuario(result));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        Connection connection = configDB.conectarComBancoDeDados();
        String queryAtualizar = String.format(
                "UPDATE dentista SET " +
                "nome = '%s', sobrenome = '%s', acesso = '%s' " +
                "WHERE id = '%s'",
                usuario.getNome(), usuario.getSobrenome(),
                usuario.getAcesso(), usuario.getId());

        execute(connection, queryAtualizar);
        return usuario;
    }

    private Usuario criarObjetoUsuario(ResultSet resultSet) throws SQLException {
        return new Usuario(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("sobrenome"),
                resultSet.getInt("acesso"));
    }

    private void execute(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
