package br.inatel.controllers.DAO;

import br.inatel.models.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "funcionario"
 */
public class FuncionarioDAO extends ConnectionDAO<Funcionario> {

    /**
     * Método para obter a query de inserção específica do Funcionario
     * @return "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Funcionario para inserir
     * @param pst PreparedStatement
     * @param funcionario objeto Funcionario a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Funcionario funcionario) throws SQLException {
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getTelefone());
        pst.setInt(3, funcionario.getSalario());
        pst.setString(4, funcionario.getSenha());
        pst.setInt(5, funcionario.getIdLocadora());
    }

}
