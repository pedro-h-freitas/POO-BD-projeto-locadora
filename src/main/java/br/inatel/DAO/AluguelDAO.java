package br.inatel.DAO;

import br.inatel.models.Aluguel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for CREATE, READ, UPDATE objects of the table "aluguel"
 */
public class AluguelDAO extends ConnectionDAO {

    /**
     * Função para criar um novo objeto na tabela "aluguel"
     * @param aluguel Objeto Aluguel que irá adicionar
     * @return id do aluguel criado (-1: não foi criado)
     */
    public int insertAluguel(Aluguel aluguel){
        int id = -1;

        connectToDB();

        String sql = "INSERT INTO aluguel(data_locacao, id_cliente, id_locadora) VALUES(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, aluguel.getdataLocacao());
            pst.setInt(2, aluguel.getIdCliente());
            pst.setInt(3, aluguel.getIdLocadora());

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
