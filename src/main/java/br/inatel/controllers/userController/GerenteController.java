package br.inatel.controllers.userController;

import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Funcionario;

import java.util.ArrayList;

public class GerenteController extends FuncionarioController {
    public ArrayList<Funcionario> getAllFuncionarios() {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.selectAll();
    }

}
