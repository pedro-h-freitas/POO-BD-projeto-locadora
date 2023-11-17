package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.controllers.DAO.ClienteDAO;
import br.inatel.controllers.DAO.DAOWithId;
import br.inatel.controllers.DAO.FuncionarioDAO;
import br.inatel.models.Cliente;
import br.inatel.models.Funcionario;

/**
 * Classe para manipular as ações na tela de Login
 */
public class LoginController {
    /**
     * Realiza um login
     * @param id id do usuario
     * @param senha senha do usuario
     * @return contexto (1: Funcionario | 2: Cliente | 3: Gerente | -1: id não encontrado | -2: senha incorreta)
     */
    public int login(String id, String senha) {
        if (id.charAt(0) == '1') {
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario funcionario = dao.selectById(Integer.parseInt(id));

            if (funcionario == null)
                return -1;
            if (!funcionario.getSenha().equals(senha))
                return -2;

            Main.context.setUserId(funcionario.getId());
            Main.context.setUserType("Funcionario");
            Main.context.setLocadoraId(funcionario.getIdLocadora());

            return 1;
        }
        else if (id.charAt(0) == '2') {
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = dao.selectById(Integer.parseInt(id));

            if (cliente == null)
                return -1;
            if (!cliente.getSenha().equals(senha))
                return -2;

            Main.context.setUserId(cliente.getId());
            Main.context.setUserType("Cliente");

            return 2;
        }
        return -1;
    }
}
