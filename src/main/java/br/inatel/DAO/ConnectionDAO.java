package br.inatel.DAO;

import br.inatel.config.DbConfig;

import java.sql.*;

/**
 * Super class for all DAO's class (DAO - Data Access Object)
 */
public abstract class ConnectionDAO {

    protected Connection con;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;

    //Config DataBase
    private DbConfig config = new DbConfig();

    //Information for connect to DB
    private String user = config.getUser();
    private String password = config.getPassword();
    private String url = config.getUrl();

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

}