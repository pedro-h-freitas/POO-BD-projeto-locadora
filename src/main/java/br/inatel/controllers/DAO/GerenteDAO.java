package br.inatel.controllers.DAO;

import br.inatel.models.Gerente;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "gerente"
 */
public class GerenteDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "gerente"
     *
     * @param gerente Objeto Gerente que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertGerente(Gerente gerente) {
        connectToDB();

        String sql = "INSERT INTO gerente(id_funcionario) VALUES(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, gerente.getIdFuncionario());
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
