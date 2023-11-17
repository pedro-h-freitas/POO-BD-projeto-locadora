package br.inatel.controllers.DAO;

import br.inatel.models.Funcionario;

import java.sql.SQLException;

/**
 * Classe para manipular DAO com ID
 * @param <T> Model usado no DAO
 */
public abstract class DAOWithId<T> extends ConnectionDAO<T>{


    /**
     * Método abstrato para obter a query de seleção por id para cada tabela
     * @return query de busca
     */
    protected abstract String getSelectByIdQuery();

    /**
     * Método abstrato para mapear o ResultSet em um model
     * @return Objeto T mapeado no ResultSet
     */
    protected abstract T getMapper();

    /**
     * Busca um objeto T em pelo id sua respectiva tabela
     * @param id do objeto selecionado
     * @return Objeto T selecionado
     */
    public T selectById(int id){
        connectToDB();
        Funcionario funcionario = null;

        String sql = getSelectByIdQuery();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                return getMapper();
            }

            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                // st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return null;
    }
}
