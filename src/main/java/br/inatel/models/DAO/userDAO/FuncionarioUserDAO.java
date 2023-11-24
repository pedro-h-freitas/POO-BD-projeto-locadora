package br.inatel.models.DAO.userDAO;

import br.inatel.models.Funcionario;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for CREATE, READ, UPDATE objects of the table "funcionario"
 */
public class FuncionarioUserDAO extends UserDAO<Funcionario> {

    /**
     * Método para obter a query de inserção específica do Funcionario
     * @return "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO funcionario(nome, telefone, salario, senha, id_locadora) VALUES(?, ?, ?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Funcionario para inserir
     * @param pst PreparedStatement
     * @param funcionario objeto Funcionario a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Funcionario funcionario) throws SQLException {
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getTelefone());
        pst.setInt(3, funcionario.getSalario());
        pst.setString(4, funcionario.getSenha());
        pst.setInt(5, funcionario.getIdLocadora());
    }

    /**
     * Método para obter a query de seleção por id do Funcionario
     * @return "SELECT * FROM funcionario WHERE id=?"
     */
    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM funcionario WHERE id=?";
    }

    /**
     * Função para mapear um ResultSet em um model.Funcionario
     * @return Objeto Funcionario mapeado do ResultSet
     */
    @Override
    public Funcionario getMapper() {
        try {
            return new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getInt("salario"),
                    rs.getString("senha"),
                    rs.getInt("id_locadora")
            );
        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            return null;
        }
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM funcionario WHERE id=?";
    }

    @Override
    protected void setDeleteValues(PreparedStatement pst, int id) throws SQLException {
        pst.setInt(1, id);
    }

    @Override
    protected String getSelectNomeQuery() {
        return "SELECT nome FROM funcionario WHERE id=?";
    }

    public ArrayList<Funcionario> selectByLocadora(int idLocadora){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM funcionario WHERE id_locadora=?;";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLocadora);
            rs = pst.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = getMapper();
                funcionarios.add(funcionario);
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
        return funcionarios;
    }

    public boolean update(Funcionario funcionario) {
        connectToDB();

        String sql = "UPDATE funcionario " +
                "SET nome=?, telefone=?, salario=?, senha=?, id_locadora=? " +
                "WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getTelefone());
            pst.setInt(3, funcionario.getSalario());
            pst.setString(4, funcionario.getSenha());
            pst.setInt(5, funcionario.getIdLocadora());
            pst.setInt(6, funcionario.getId());
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

    public boolean updateLocadora(int idFuncionario, int idLocadora) {
        connectToDB();

        String sql = "UPDATE funcionario " +
                "SET id_locadora=? " +
                "WHERE id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idLocadora);
            pst.setInt(2, idFuncionario);
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
