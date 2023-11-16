package br.inatel.controllers.DAO;

import br.inatel.models.InfoFilme;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "info_filme"
 */
public class InfoFilmeDAO extends ConnectionDAO<InfoFilme> {

    /**
     * Método para obter a query de inserção específica do InfoFilme
     * @return "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)";
    }

    /**
     * Método para definir os valores de um InfoFilme para inserir
     * @param pst PreparedStatement
     * @param infoFilme objeto InfoFilme a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, InfoFilme infoFilme) throws SQLException {
        pst.setString(1, infoFilme.getNome());
        pst.setInt(2, infoFilme.getAnoLancamento());
    }
}
