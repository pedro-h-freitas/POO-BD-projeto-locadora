package br.inatel.controllers.DAO;

import br.inatel.models.Filme;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for CREATE, READ, UPDATE objects of the table "filme"
 */
public class FilmeDAO extends ConnectionDAO<Filme> {

    /**
     * Método para obter a query de inserção específica do Filme
     * @return "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO filme(n_copias, id_locadora, id_info_filme) VALUES(?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Filme para inserir
     * @param pst PreparedStatement
     * @param filme objeto Filme a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Filme filme) throws SQLException {
        pst.setInt(1, filme.getnCopias());
        pst.setInt(2, filme.getIdLocadora());
        pst.setInt(3, filme.getIdInfoFilme());
    }

    //DELETE
    public boolean deleteById(int id) {
        connectToDB();

        String sql = "DELETE FROM filme where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
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
        return sucesso;
    }

    public boolean removeQnt(int id, int qnt) {
        connectToDB();
        String sql = """
                UPDATE filme\s
                SET n_copias=n_copias-?, n_disponiveis=n_disponiveis-?
                WHERE id=?;
                """;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, qnt);
            pst.setInt(2, qnt);
            pst.setInt(3, id);
            pst.execute();
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
        return sucesso;
    }

}
