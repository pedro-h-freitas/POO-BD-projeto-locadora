package br.inatel.controllers.DAO;

import br.inatel.config.DbConfig;

import java.sql.*;

/**
 * Super class for all DAO's class (DAO - Data Access Object)
 */
public abstract class ConnectionDAO<T> {

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
     * Function for connect to DB
     */
    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao deu certo!");
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }

    protected abstract String getInsertQuery();

    protected abstract void setInsertValues(PreparedStatement pst, T object) throws SQLException;

    public boolean insert(T object) {
        connectToDB();

        String sql = getInsertQuery();
        try {
            pst = con.prepareStatement(sql);
            setInsertValues(pst, object);
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