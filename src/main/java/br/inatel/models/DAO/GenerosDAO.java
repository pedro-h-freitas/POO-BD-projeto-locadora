package br.inatel.models.DAO;

import br.inatel.models.Generos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "generos"
 */
public class GenerosDAO extends ConnectionDAO<Generos> {

    /**
     * Método para obter a query de inserção específica do Generos
     * @return "INSERT INTO generos(id_filme, nome) VALUES(?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO generos(id_info_filme, nome) VALUES(?, ?)";
    }

    /**
     * Método para definir os valores de um Generos para inserir
     * @param pst PreparedStatement
     * @param generos objeto Generos a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Generos generos) throws SQLException {
        pst.setInt(1, generos.getIdInfoFilme());
        pst.setString(2, generos.getNome());
    }
}
