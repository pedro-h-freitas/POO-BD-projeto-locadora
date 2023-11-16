package br.inatel.controllers.DAO;

import br.inatel.models.Filme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme"
 */
public class FilmeDAO extends ConnectionDAO<Filme> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, Filme filme) throws SQLException {
        pst.setInt(1, filme.getnCopias());
        pst.setInt(2, filme.getIdLocadora());
        pst.setInt(3, filme.getIdInfoFilme());
    }
}
