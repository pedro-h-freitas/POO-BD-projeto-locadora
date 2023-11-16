package br.inatel.controllers.DAO;

import br.inatel.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "cliente"
 */
public class ClienteDAO extends ConnectionDAO<Cliente> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO cliente(nome, cpf, senha, endereco, telefone, email) VALUES(?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement pst, Cliente cliente) throws SQLException {
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getSenha());
        pst.setString(4, cliente.getEndereco());
        pst.setString(5, cliente.getTelefone());
        pst.setString(6, cliente.getEmail());
    }

}
