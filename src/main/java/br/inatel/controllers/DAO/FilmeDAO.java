package br.inatel.controllers.DAO;

import br.inatel.models.Filme;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<FilmeDisplay> selectFilmeDisplayByIdLocadora(int idLocadora) {
        ArrayList<FilmeDisplay> filmes = new ArrayList<>();

        connectToDB();

        String sql = "select filme.id, info_filme.nome as nome, info_filme.ano_lancamento as ano,\n" +
                "GROUP_CONCAT(generos.nome) as generos\n" +
                "from filme \n" +
                "join info_filme on info_filme.id = filme.id_info_filme\n" +
                "join generos on info_filme.id = generos.id_info_filme\n" +
                "where id_locadora=? and n_disponiveis > 0\n" +
                "GROUP BY filme.id;";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLocadora);
            rs = pst.executeQuery();

            while (rs.next()) {
                FilmeDisplay filme = new FilmeDisplay(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("ano"),
                        rs.getString("generos")
                );
                filmes.add(filme);
            }

            sucesso = true;
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

        return filmes;
    }

}
