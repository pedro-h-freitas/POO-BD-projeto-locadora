package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.DAO.userDAO.GerenteUserDAO;
import br.inatel.models.Funcionario;

import java.util.ArrayList;

public class GerenteController extends FuncionarioController {
    public ArrayList<Funcionario> getAllFuncionarios() {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        ArrayList<Funcionario> funcionarios = funcionarioUserDAO.selectByLocadora(Main.context.getLocadoraId());

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == Main.context.getUserId()){
                funcionarios.remove(i);
                break;
            }
        }

        return funcionarios;
    }

}
