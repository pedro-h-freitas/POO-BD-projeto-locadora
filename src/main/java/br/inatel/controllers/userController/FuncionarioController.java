package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.AluguelDAO;
import br.inatel.controllers.DAO.LocadoraDAO;
import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.controllers.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Cliente;
import br.inatel.views.utils.ColorPrinter;

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

    public int getIdAluguel(int idCliente) {
        AluguelDAO aluguelDAO = new AluguelDAO();

        return aluguelDAO.selectAluguelIdByCliente(idCliente);
    }

    public boolean hasAluguel(int idCliente) {
        return getIdAluguel(idCliente) != -1;
    }

    public void deleteUser(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();

        clienteUserDAO.delete(idCliente);
        ColorPrinter.printAzul("Usuario: ");
        ColorPrinter.printVermelho(idCliente + "");
        ColorPrinter.printAzul(" deletado\n");

        Main.context.setUserId(-1);
        Main.context.setUserType(null);
        Main.context.setLocadoraId(-1);
    }

}
