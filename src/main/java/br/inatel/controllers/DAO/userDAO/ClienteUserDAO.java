package br.inatel.controllers.DAO.userDAO;

import br.inatel.models.Cliente;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM cliente WHERE id=?";
    }

    @Override
    protected void setDeleteValues(PreparedStatement pst, int id) throws SQLException {
        pst.setInt(1, id);
    }

    @Override
    protected String getSelectNomeQuery() {
        return "SELECT nome FROM cliente WHERE id=?";
    }

    /**
     * Método para mapear um ResultSet em um model.Cliente
     * @return Objeto Cliente mapeado no ResultSet
     */
    @Override
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
            ColorPrinter.printErro(e);
            return null;
        }
    }

    public ArrayList<Cliente> selectAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM cliente";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = getMapper();
                clientes.add(cliente);
            }

            sucesso = true;
        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            sucesso = false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                ColorPrinter.printErro(e);
            }
        }

        return clientes;
    }

    public boolean update(Cliente cliente) {
        connectToDB();
        String sql = "UPDATE cliente " +
                "SET nome=?, cpf=?, senha=?, endereco=?, telefone=?, email=? " +
                "WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getSenha());
            pst.setString(4, cliente.getEndereco());
            pst.setString(5, cliente.getTelefone());
            pst.setString(6, cliente.getEmail());
            pst.setInt(7, cliente.getId());
            pst.execute();
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro = " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return sucesso;
    }

}
