package br.inatel.controllers.DAO;

import br.inatel.models.FilmeAlugado;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme_alugado"
 */
public class FilmeAlugadoDAO extends ConnectionDAO<FilmeAlugado> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO filme_alugado(id_aluguel, id_filme) VALUES(?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, FilmeAlugado filmeAlugado) throws SQLException {
        pst.setInt(1, filmeAlugado.getIdAluguel());
        pst.setInt(2, filmeAlugado.getIdFilme());
    }
}
