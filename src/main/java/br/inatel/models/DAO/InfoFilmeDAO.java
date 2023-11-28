package br.inatel.models.DAO;

import br.inatel.models.InfoFilme;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for CREATE, READ, UPDATE objects of the table "info_filme"
 */
public class InfoFilmeDAO extends ConnectionDAO<InfoFilme> {

    /**
     * Método para obter a query de inserção específica do InfoFilme
     * @return "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO info_filme(nome, ano_lancamento) VALUES(?, ?)";
    }

    /**
     * Método para definir os valores de um InfoFilme para inserir
     * @param pst PreparedStatement
     * @param infoFilme objeto InfoFilme a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, InfoFilme infoFilme) throws SQLException {
        pst.setString(1, infoFilme.getNome());
        pst.setInt(2, infoFilme.getAnoLancamento());
    }

    /**
     * Insere um Filme em sua respectiva tabela
     * @param object Filme a ser inserido
     * @return int var (id do Filme | -1: falhou)
     */
    @Override
    public int insert(InfoFilme object) {
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

    /**
     * Deleta informações de um filme pelo id
     * @param id Id do objeto selecionado
     */
    public void delete(int id) {
        connectToDB();

        String sql = "DELETE FROM info_filme WHERE id=?;";
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
    }
}
