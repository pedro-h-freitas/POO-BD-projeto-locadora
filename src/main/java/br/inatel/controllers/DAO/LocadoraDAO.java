package br.inatel.controllers.DAO;

import br.inatel.models.Locadora;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "locadora"
 */
public class LocadoraDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "locadora"
     *
     * @param locadora Objeto InfoFilme que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertLocadora(Locadora locadora) {
        connectToDB();

        String sql = "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, locadora.getNome());
            pst.setString(2, locadora.getEndereco());
            pst.setInt(3, locadora.getIdGerente());
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
