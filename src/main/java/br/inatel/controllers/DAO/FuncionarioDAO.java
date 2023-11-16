package br.inatel.controllers.DAO;

import br.inatel.models.Funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "funcionario"
 */
public class FuncionarioDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "funcionario"
     * @param funcionario Objeto Funcionario que irá adicionar
     * @return id do funcionario adicionado (-1: não foi adicionado)
     */
    public int insertFuncionario(Funcionario funcionario) {
        connectToDB();
        int id = -1;

        String sql = "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setInt(3, funcionario.getSalario());
            pst.setString(4, funcionario.getSenha());
            pst.setInt(5, funcionario.getIdLocadora());

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
