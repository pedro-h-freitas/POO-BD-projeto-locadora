package br.inatel.controllers.DAO;

import br.inatel.config.DbConfig;

import java.sql.*;

/**
 * Super classe para todas classes DAO (DAO - Data Access Object)
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

    /**
     * Método abstrato para obter a query de inserção específica para cada tabela
     * @return query de inserção
     */
    protected abstract String getInsertQuery();

    /**
     * Método abstrato para definir os valores específicos para cada tabela
     * @param pst PreparedStatement
     * @param object objeto T a ser inserido
     * @throws SQLException Exceção de SQL
     */
    protected abstract void setInsertValues(PreparedStatement pst, T object) throws SQLException;

    /**
     * Insere um objet T em sua respectiva tabela
     * @param object objeto a ser inserido
     * @return boolean var (true: inseriu | false: falhou)
     */
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