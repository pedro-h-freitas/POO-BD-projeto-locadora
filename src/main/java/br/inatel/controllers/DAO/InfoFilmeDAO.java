package br.inatel.controllers.DAO;

import br.inatel.models.InfoFilme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "info_filme"
 */
public class InfoFilmeDAO extends ConnectionDAO<InfoFilme> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, InfoFilme infoFilme) throws SQLException {
        pst.setString(1, infoFilme.getNome());
        pst.setInt(2, infoFilme.getAnoLancamento());
    }
}
