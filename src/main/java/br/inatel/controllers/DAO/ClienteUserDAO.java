package br.inatel.controllers.DAO;

import br.inatel.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "cliente"
 */
public class ClienteUserDAO extends UserDAO<Cliente> {

    /**
     * Método para obter a query de inserção específica do Cliente
     * @return "INSERT INTO cliente(nome, cpf, senha, endereco, telefone, email) VALUES(?, ?, ?, ?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO cliente(nome, cpf, senha, endereco, telefone, email) VALUES(?, ?, ?, ?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Cliente para inserir
     * @param pst PreparedStatement
     * @param cliente objeto Cliente a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Cliente cliente) throws SQLException {
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getSenha());
        pst.setString(4, cliente.getEndereco());
        pst.setString(5, cliente.getTelefone());
        pst.setString(6, cliente.getEmail());
    }

    /**
     * Método para obter a query de seleção por id do Cliente
     * @return "SELECT * FROM cliente WHERE id=?"
     */
    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM cliente WHERE id=?";
    }

    /**
     * Método para mapear um ResultSet em um model.Cliente
     * @return Objeto Cliente mapeado no ResultSet
     */
    public Cliente getMapper() {
        try {
            return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email")
            );
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }}
