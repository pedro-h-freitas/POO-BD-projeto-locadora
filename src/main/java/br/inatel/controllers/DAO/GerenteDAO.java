package br.inatel.controllers.DAO;

import br.inatel.models.Gerente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "gerente"
 */
public class GerenteDAO extends ConnectionDAO<Gerente> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO gerente(id_funcionario) VALUES(?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, Gerente gerente) throws SQLException {
        pst.setInt(1, gerente.getIdFuncionario());
    }
}
