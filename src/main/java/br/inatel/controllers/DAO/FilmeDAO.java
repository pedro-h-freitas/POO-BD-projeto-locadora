package br.inatel.controllers.DAO;

import br.inatel.models.Filme;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme"
 */
public class FilmeDAO extends ConnectionDAO<Filme> {

    /**
     * Método para obter a query de inserção específica do Filme
     * @return "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Filme para inserir
     * @param pst PreparedStatement
     * @param filme objeto Filme a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Filme filme) throws SQLException {
        pst.setInt(1, filme.getnCopias());
        pst.setInt(2, filme.getIdLocadora());
        pst.setInt(3, filme.getIdInfoFilme());
    }
}
