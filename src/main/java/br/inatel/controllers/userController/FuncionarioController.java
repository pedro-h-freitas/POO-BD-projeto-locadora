package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.LocadoraDAO;
import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.controllers.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Cliente;

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
}
