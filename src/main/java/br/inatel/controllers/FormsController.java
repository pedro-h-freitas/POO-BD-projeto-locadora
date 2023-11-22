package br.inatel.controllers;

import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.Cliente;

/**
 * Classe para manipular as ações na tela de Cadastro
 */
public class FormsController extends Controller {
    /**
     * Realiza o cadastro de um cliente
     * @param cliente cliente a ser inserido
     * @return boolean var (true: cadastrou | false: falhou)
     */
    public int cadastroCliente(Cliente cliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.insert(cliente);
    }

    public boolean updateCliente(Cliente cliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.update(cliente);
    }

    public Cliente getCliente(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectById(idCliente);
    }

}
