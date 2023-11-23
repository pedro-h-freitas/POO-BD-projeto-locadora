package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.models.DAO.FilmeDisplayDAO;
import br.inatel.models.DAO.LocadoraDAO;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Cliente;
import br.inatel.models.FilmeDisplay;

import java.util.ArrayList;

public class FuncionarioController {

    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

    public String getNomeFuncionario() {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.selectNome(Main.context.getUserId());
    }

    public ArrayList<Cliente> getAllClientes() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectAll();
    }

    public ArrayList<FilmeDisplay> getFilmesLocadora() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        int locadoraId = Main.context.getLocadoraId();

        return filmeDisplayDAO.selectByLocadora(locadoraId);
    }

    public ArrayList<FilmeDisplay> getFilmesInfos() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();

        return filmeDisplayDAO.selectInfos();
    }

}
