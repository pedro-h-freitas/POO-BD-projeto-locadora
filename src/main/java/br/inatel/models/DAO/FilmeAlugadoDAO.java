package br.inatel.models.DAO;

import br.inatel.models.FilmeAlugado;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme_alugado"
 */
public class FilmeAlugadoDAO extends ConnectionDAO<FilmeAlugado> {

    /**
     * Método para obter a query de inserção específica do FilmeAlugado
     * @return "INSERT INTO filme_alugado(id_aluguel, id_filme) VALUES(?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO filme_alugado(id_aluguel, id_filme) VALUES(?, ?)";
    }

    /**
     * Método para definir os valores de um FilmeAlugado para inserir
     * @param pst PreparedStatement
     * @param filmeAlugado objeto FilmeAlugado a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, FilmeAlugado filmeAlugado) throws SQLException {
        pst.setInt(1, filmeAlugado.getIdAluguel());
        pst.setInt(2, filmeAlugado.getIdFilme());
    }
}
