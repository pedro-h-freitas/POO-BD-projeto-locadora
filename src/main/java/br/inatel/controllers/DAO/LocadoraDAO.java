package br.inatel.controllers.DAO;

import br.inatel.models.Locadora;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "locadora"
 */
public class LocadoraDAO extends ConnectionDAO<Locadora> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, Locadora locadora) throws SQLException {
        pst.setString(1, locadora.getNome());
        pst.setString(2, locadora.getEndereco());
        pst.setInt(3, locadora.getIdGerente());
    }
}
