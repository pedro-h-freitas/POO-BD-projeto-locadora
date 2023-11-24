package br.inatel.models.DAO;

import br.inatel.models.Aluguel;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for CREATE, READ, UPDATE objects of the table "aluguel"
 */
public class AluguelDAO extends ConnectionDAO<Aluguel> {

    /**
     * Método para obter a query de inserção específica do Aluguel
     * @return "INSERT INTO aluguel(data_locacao, id_cliente, id_locadora) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO aluguel(id_cliente, id_locadora) VALUES(?, ?)";
    }

    /**
     * Método para definir os valores de um Aluguel para inserir
     * @param pst PreparedStatement
     * @param aluguel Aluguel a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Aluguel aluguel) throws SQLException {
        pst.setInt(1, aluguel.getIdCliente());
        pst.setInt(2, aluguel.getIdLocadora());
    }

    @Override
    public int insert(Aluguel object) {
        int id = -1;

        connectToDB();

        String sql = getInsertQuery();
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setInsertValues(pst, object);
            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if(generatedKeys.next()) {
                        id = generatedKeys.getInt(1);
                    } else {
                        System.out.println("Erro ao recuperar o ID gerado");
                    }
                }
            } else {
                System.out.println("Nenhum registro foi inserido");
            }

            sucesso = true;
        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                ColorPrinter.printErro(e);
            }
        }

        return id;
    }

    public int selectAluguelIdByCliente(int idCliente) {
        int idAluguel = -1;

        connectToDB();

        String sql = "select id from aluguel where id_cliente=? and status!='entregue';";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCliente);
            rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                sucesso = true;
                idAluguel = rs.getInt("id");
            }

        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            sucesso = false;
        } finally {
            try {
                con.close();
                // st.close();
            } catch (SQLException e) {
                ColorPrinter.printErro(e);
            }
        }
        return idAluguel;
    }

    public void devolver(int id) {
        connectToDB();

        String sql = """
                UPDATE aluguel
                SET status = 'entregue'
                WHERE id=?;
                """;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
}
