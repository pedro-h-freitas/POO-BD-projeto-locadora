package br.inatel.controllers.DAO;

import br.inatel.models.Cliente;
import br.inatel.models.Locadora;
import br.inatel.views.utils.ColorPrinter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for CREATE, READ, UPDATE objects of the table "locadora"
 */
public class LocadoraDAO extends ConnectionDAO<Locadora> {

    /**
     * Método para obter a query de inserção específica do Locadora
     * @return "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)"
     */
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO locadora(nome, endereco, id_gerente) VALUES(?, ?, ?)";
    }

    /**
     * Método para definir os valores de um Locadora para inserir
     * @param pst PreparedStatement
     * @param locadora objeto Locadora a ser inserido
     * @throws SQLException Exceção de SQL
     */
    @Override
    protected void setInsertValues(PreparedStatement pst, Locadora locadora) throws SQLException {
        pst.setString(1, locadora.getNome());
        pst.setString(2, locadora.getEndereco());
        pst.setInt(3, locadora.getIdGerente());
    }

    /**
     * Método para mapear um ResultSet em um model.Cliente
     * @return Objeto Cliente mapeado no ResultSet
     */
    public Locadora getMapper() {
        try {
            return new Locadora(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getInt("id_gerente")
            );
        } catch (SQLException e) {
            ColorPrinter.printErro(e);
            return null;
        }
    }

    /**
     * Busca todas as locadoras
     * @return Lista com todas locadoras do sistema
     */
    public ArrayList<Locadora> selectAll() {
        ArrayList<Locadora> locadoras = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM locadora";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Locadora locadora = getMapper();
                locadoras.add(locadora);
            }

            sucesso = true;
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

        return locadoras;
    }
}
