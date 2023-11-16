package br.inatel.controllers.DAO;

import br.inatel.models.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "cliente"
 */
public class ClienteDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "cliente"
     * @param cliente Objeto Cliente que irá adicionar
     * @return id do cliente adicionado (-1: não foi adicionado)
     */
    public int insertCliente(Cliente cliente){
        int id = -1;

        connectToDB();

        String sql = "INSERT INTO cliente(nome, cpf, senha, endereco, telefone, email) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getSenha());
            pst.setString(4, cliente.getEndereco());
            pst.setString(5, cliente.getTelefone());
            pst.setString(6, cliente.getEmail());

            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        id = generatedKeys.getInt(1);
                    }
                }
            }

            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return id;
    }
}
