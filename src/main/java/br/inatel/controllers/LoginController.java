package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.DAO.userDAO.GerenteUserDAO;
import br.inatel.models.Cliente;
import br.inatel.models.Funcionario;
import br.inatel.models.Gerente;

/**
 * Classe para manipular as ações na tela de Login
 */
public class LoginController {
    /**
     * Realiza um login
     * @param id id do usuario
     * @param senha senha do usuario
     * @return contexto (1: Gerente | 2: Funcionario | 3: Cliente | -1: id não encontrado | -2: senha incorreta)
     */
    public int login(String id, String senha) {
        if (id.charAt(0) == '1') {
            FuncionarioUserDAO funcionarioDAO = new FuncionarioUserDAO();
            Funcionario funcionario = funcionarioDAO.selectById(Integer.parseInt(id));

            if (funcionario == null)
                return -1;
            if (!funcionario.getSenha().equals(senha))
                return -2;

            GerenteUserDAO gerenteDAO = new GerenteUserDAO();
            Gerente gerente = gerenteDAO.selectById(Integer.parseInt(id));
            if (!(gerente == null)) {
                Main.context.setUserId(funcionario.getId());
                Main.context.setUserType(Context.GERENTE);
                Main.context.setLocadoraId(funcionario.getIdLocadora());

                return 1;
            }

            Main.context.setUserId(funcionario.getId());
            Main.context.setUserType(Context.FUNCIONARIO);
            Main.context.setLocadoraId(funcionario.getIdLocadora());

            return 2;
        }
        else if (id.charAt(0) == '2') {
            ClienteUserDAO clienteDAO = new ClienteUserDAO();
            Cliente cliente = clienteDAO.selectById(Integer.parseInt(id));

            if (cliente == null)
                return -1;
            if (!cliente.getSenha().equals(senha))
                return -2;

            Main.context.setUserId(cliente.getId());
            Main.context.setUserType(Context.CLIENTE);
            Main.context.setLocadoraId(-1);

            return 3;
        }
        return -1;
    }
}
