package br.inatel.controllers.DAO;

import br.inatel.models.Locadora;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "locadora"
 */
public class LocadoraDAO extends ConnectionDAO<Locadora> {

    /**
     * Método para obter a query de inserção específica do Locadora
     * @return "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Locadora para inserir
     * @param pst PreparedStatement
     * @param locadora objeto Locadora a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Locadora locadora) throws SQLException {
        pst.setString(1, locadora.getNome());
        pst.setString(2, locadora.getEndereco());
        pst.setInt(3, locadora.getIdGerente());
    }
}
