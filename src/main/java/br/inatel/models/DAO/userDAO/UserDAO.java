package br.inatel.models.DAO.userDAO;

import br.inatel.models.DAO.ConnectionDAO;
import br.inatel.views.utils.ColorPrinter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe para manipular DAO com ID
 * @param <T> Model usado no DAO
 */
public abstract class UserDAO<T> extends ConnectionDAO<T> {
    /**
     * Insere um objeto T em sua respectiva tabela
     * @param object objeto a ser inserido
     * @return int var (id do objeto T | -1: falhou)
     */
    @Override
    public int insert(T object) {
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
     * Método abstrato para mapear o ResultSet em um model
     * @return Objeto T mapeado no ResultSet
     */
    protected abstract T getMapper();

    /**
     * Método abstrato para obter a query de seleção por id para cada tabela
     * @return query de busca
     */
    protected abstract String getSelectByIdQuery();

    /**
     * Busca um objeto T pelo id em sua respectiva tabela
     * @param id do objeto selecionado
     * @return Objeto T selecionado
     */
    public T selectById(int id){
        connectToDB();

        String sql = getSelectByIdQuery();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                sucesso = true;
                return getMapper();
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
        return null;
    }

    /**
     * Método abstrato para obter a query de deleção específica para cada tabela
     * @return query de inserção
     */
    protected abstract String getDeleteQuery();

    /**
     * Deleta um objeto T pelo id sua respectiva tabela
     * @param id Id do objeto selecionado
     */
    public void delete(int id) {
        connectToDB();

        String sql = getDeleteQuery();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();

            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro = " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * Método abstrato para obter a query para selecionar o nome de um usuario
     * @return query de seleção
     */
    protected abstract String getSelectNomeQuery();

    /**
     * Busca o nome de um objeto T pelo id em sua respectiva tabela
     * @param id id do objeto selecionado
     * @return Nome do um objeto T selecionado
     */
    public String selectNome(int id) {
        connectToDB();

        String sql = getSelectNomeQuery();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                sucesso = true;
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            sucesso = false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                ColorPrinter.printErro(e);
            }
        }
        return null;
    }
}
