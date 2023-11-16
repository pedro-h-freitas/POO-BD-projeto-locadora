package br.inatel.controllers.DAO;

import br.inatel.models.Filme;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme"
 */
public class FilmeDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "filme"
     * @param filme Objeto Filme que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertFilme(Filme filme) {
        connectToDB();

        String sql = "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, filme.getnCopias());
            pst.setInt(2, filme.getIdLocadora());
            pst.setInt(3, filme.getIdInfoFilme());
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
