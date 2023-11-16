package br.inatel.controllers.DAO;

import br.inatel.models.Funcionario;

import java.sql.SQLException;

public abstract class DAOWithId<T> extends ConnectionDAO<T>{

    protected abstract String getSelectByIdQuery();

    protected abstract T getMapper();

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
