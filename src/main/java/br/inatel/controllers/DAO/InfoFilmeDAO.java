package br.inatel.controllers.DAO;

import br.inatel.models.InfoFilme;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "info_filme"
 */
public class InfoFilmeDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "info_filme"
     * @param infoFilme Objeto InfoFilme que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertInfoFilme(InfoFilme infoFilme) {
        connectToDB();

        String sql = "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, infoFilme.getNome());
            pst.setInt(2, infoFilme.getAnoLancamento());
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
