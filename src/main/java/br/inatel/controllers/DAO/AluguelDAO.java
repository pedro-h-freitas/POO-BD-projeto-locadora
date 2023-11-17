package br.inatel.controllers.DAO;

import br.inatel.models.Aluguel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "aluguel"
 */
public class AluguelDAO extends ConnectionDAO<Aluguel> {

    /**
     * Método para obter a query de inserção específica do Aluguel
     * @return "INSERT INTO aluguel(data_locacao, id_cliente, id_locadora) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO aluguel(data_locacao, id_cliente, id_locadora) VALUES(?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Aluguel para inserir
     * @param pst PreparedStatement
     * @param aluguel Aluguel a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Aluguel aluguel) throws SQLException {
        pst.setString(1, aluguel.getdataLocacao());
        pst.setInt(2, aluguel.getIdCliente());
        pst.setInt(3, aluguel.getIdLocadora());
    }
}
