package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.models.DAO.FilmeDisplayDAO;
import br.inatel.models.DAO.LocadoraDAO;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Cliente;
import br.inatel.models.FilmeDisplay;

import java.util.ArrayList;

/**
 * Controler para funcionario
 */
public class FuncionarioController {

    /**
     * Método para selecionar o nome da locadora atual da sessão
     * @return nome da locadora da sessão
     */
    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

    /**
     * Método para selecionar o nome do funcionario da atual da sessão
     * @return nome do funcionario da sessão
     */
    public String getNomeFuncionario() {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.selectNome(Main.context.getUserId());
    }

    /**
     * Seleciona todos os clientes
     * @return lista de clientes
     */
    public ArrayList<Cliente> getAllClientes() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectAll();
    }

    /**
     * Seleciona todos os filmes da locadora da sessão
     * @return lista dos filmes da locadora da sessão
     */
    public ArrayList<FilmeDisplay> getFilmesByLocadora() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        return filmeDisplayDAO.selectByLocadora(Main.context.getLocadoraId());
    }

    /**
     * Seleciona todos os meta dados dos filmes
     * @return lista dos meta dados
     */
    public ArrayList<FilmeDisplay> getFilmesInfos() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        return filmeDisplayDAO.selectInfos();
    }

}
