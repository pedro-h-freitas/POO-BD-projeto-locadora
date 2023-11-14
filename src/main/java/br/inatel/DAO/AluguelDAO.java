package br.inatel.DAO;

import br.inatel.models.Aluguel;

import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "aluguel"
 */
public class AluguelDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "aluguel"
     * @param aluguel Objeto Aluguel que irá adicionar
     * @return boolean var (true: sucesso | false: falhou)
     */
    public boolean insertAluguel(Aluguel aluguel){
        connectToDB();

        String sql = "INSERT INTO aluguel(data_locacao, id_cliente, id_locadora) VALUES(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, aluguel.getdataLocacao());
            pst.setInt(2, aluguel.getIdCliente());
            pst.setInt(3, aluguel.getIdLocadora());
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
