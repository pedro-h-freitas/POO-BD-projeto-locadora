package br.inatel.DAO;

import br.inatel.models.Funcionario;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "funcionario"
 */
public class FuncionarioDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "funcionario"
     * @param funcionario Objeto Funcionario que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertFuncionario(Funcionario funcionario) {
        connectToDB();

        String sql = "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setInt(3, funcionario.getSalario());
            pst.setString(4, funcionario.getSenha());
            pst.setInt(5, funcionario.getIdLocadora());
            pst.execute();
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

        return sucesso;
    }

}
