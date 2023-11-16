package br.inatel.controllers.DAO;

import br.inatel.models.Generos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "generos"
 */
public class GenerosDAO extends ConnectionDAO<Generos> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO generos(id_filme, nome) VALUES(?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, Generos generos) throws SQLException {
        pst.setInt(1, generos.getIdInfoFilme());
        pst.setString(2, generos.getNome());
    }
}
