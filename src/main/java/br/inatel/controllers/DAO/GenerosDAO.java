package br.inatel.controllers.DAO;

import br.inatel.models.Generos;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "generos"
 */
public class GenerosDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "generos"
     * @param generos Objeto Generos que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertFilmeAlugado(Generos generos) {
        connectToDB();

        String sql = "INSERT INTO generos(id_filme, nome) VALUES(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, generos.getIdInfoFilme());
            pst.setString(2, generos.getNome());
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
