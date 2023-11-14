package br.inatel.DAO;

import br.inatel.models.FilmeAlugado;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme_alugado"
 */
public class FilmeAlugadoDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "filme_alugado"
     * @param filmeAlugado Objeto FilmeAlugado que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertFilmeAlugado(FilmeAlugado filmeAlugado) {
        connectToDB();

        String sql = "INSERT INTO filme_alugado(id_aluguel, id_filme) VALUES(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, filmeAlugado.getIdAluguel());
            pst.setInt(2, filmeAlugado.getIdFilme());
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
