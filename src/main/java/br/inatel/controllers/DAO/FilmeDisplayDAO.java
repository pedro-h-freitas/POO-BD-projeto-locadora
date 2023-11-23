package br.inatel.controllers.DAO;

import br.inatel.config.DbConfig;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.utils.ColorPrinter;

import java.sql.*;
import java.util.ArrayList;

public class FilmeDisplayDAO {

    protected Connection con;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;

    //Config DataBase
    private final DbConfig config = new DbConfig();

    //Information for connect to DB
    private final String user = config.getUser();
    private final String password = config.getPassword();
    private final String url = config.getUrl();

    protected boolean sucesso = false; // define se uma request falhou ou sucedeu

    /**
     * Função para conectar no Banco de Dados
     */
    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            // System.out.println("Conexao deu certo!");
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }

    public ArrayList<FilmeDisplay> selectByLocadora(int idLocadora) {
        ArrayList<FilmeDisplay> filmes = new ArrayList<>();

        connectToDB();

        String sql = """
                select filme.id, info_filme.nome, info_filme.ano_lancamento as ano,
                GROUP_CONCAT(generos.nome) as generos, filme.n_copias, filme.n_disponiveis
                from filme\s
                join info_filme on info_filme.id = filme.id_info_filme
                join generos on info_filme.id = generos.id_info_filme
                where id_locadora=? and n_disponiveis > 0
                GROUP BY filme.id;""";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLocadora);
            rs = pst.executeQuery();

            while (rs.next()) {
                FilmeDisplay filme = new FilmeDisplay(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("ano"),
                        rs.getString("generos"),
                        rs.getInt("n_copias"),
                        rs.getInt("n_disponiveis")
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

    public ArrayList<FilmeDisplay> selectByAluguel(int idAluguel) {
        ArrayList<FilmeDisplay> filmes = new ArrayList<>();

        connectToDB();

        String sql = """
                select filme.id, info_filme.nome as nome, info_filme.ano_lancamento as ano,
                GROUP_CONCAT(generos.nome) as generos, filme.n_copias, filme.n_disponiveis
                from filme_alugado\s
                join filme on filme.id = filme_alugado.id_filme
                join info_filme on info_filme.id = filme.id_info_filme
                join generos on info_filme.id = generos.id_info_filme
                where id_aluguel=? and n_disponiveis > 0
                GROUP BY filme.id;""";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAluguel);
            rs = pst.executeQuery();

            while (rs.next()) {
                FilmeDisplay filme = new FilmeDisplay(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("ano"),
                        rs.getString("generos"),
                        rs.getInt("n_copias"),
                        rs.getInt("n_disponiveis")
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
