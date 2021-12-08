package com.digitalhouse.clinicaodonto.impl;

import com.digitalhouse.clinicaodonto.configuration.ConfigurationJDBC;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.service.IDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfigurationJDBC configurationJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoH2.class);

    public DentistaDaoH2() {
        this.configurationJDBC = new ConfigurationJDBC();
    }

    @Override
    public Dentista cadastrar(Dentista dentista) {
        log.debug("Registro de dentista:" + dentista.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "INSERT INTO DENTISTA (" +
                "NOME, SOBRENOME, MATRICULA) " +
                "VALUES ('%s', '%s', '%s')",
                dentista.getNome(),
                dentista.getSobrenome(),
                dentista.getMatricula());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                dentista.setId(keys.getInt(1));


        } catch(SQLException e) {
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscar(Integer id) {
        log.debug("Buscando dentista com id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscaId = String.format("SELECT ID, NOME, SOBRENOME, MATRICULA FROM DENTISTA WHERE ID = '%S", id);
        Dentista dentista = null;

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBuscaId);
            while (result.next()) {
                dentista = criarDentista(result);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Excluindo dentista de id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryExcluindoId = String.format("DELETE FROM DENTISTA WHERE ID = '%s", id);

        try {
            statement = connection.createStatement();
            statement.executeUpdate(queryExcluindoId);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Dentista> buscarTodos() {
        log.debug("Dentistas cadastrados no sistema: ");
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscaTodos = "SELECT * FROM DENTISTA";
        List<Dentista> dentistas = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queryBuscaTodos);

            while (result.next()) {
                dentistas.add(criarDentista(result));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentistas;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        log.debug("Atualizando dentista: " + dentista.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();

        String queryUpdate = String.format("UPDATE DENTISTA SET NOME = '%s', SOBRENOME = '%s', MATRICULA = '%s' WHERE ID = '%s'",
                dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula(), dentista.getId());

        execute(connection, queryUpdate);
        return dentista;
    }

    private  void execute(Connection connection, String queryUpdate) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(queryUpdate);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Dentista criarDentista(ResultSet result) throws SQLException {

        Integer idDentista = result.getInt("ID");
        String nome = result.getNString("NOME");
        String sobrenome = result.getNString("SOBRENOME");
        String matricula = result.getNString("MATRICULA");

        return  new Dentista(idDentista, nome, sobrenome, matricula);
    }
}
