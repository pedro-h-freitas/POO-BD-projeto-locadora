package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.controllers.DAO.ClienteDAO;
import br.inatel.models.Cliente;

/**
 * Classe para manipular as ações na tela de Cadastro
 */
public class CadastroController {
    /**
     * Realiza o cadastro de um cliente
     * @param nome nome do cliente
     * @param cpf cpf do cliente
     * @param senha senha do cliente
     * @param endereco endereco do cliente
     * @param telefone telefone do cliente
     * @param email email do cliente
     * @return boolean var (true: cadastrou | false: falhou)
     */
    public boolean cadastroCliente(
            String nome,
            String cpf,
            String senha,
            String endereco,
            String telefone,
            String email
    ) {
        ClienteDAO clienteDAO = new ClienteDAO();
        int id = clienteDAO.insert(new Cliente(
                nome,
                cpf,
                senha,
                endereco,
                telefone,
                email
        ));

        if (id == -1) {
            return false;
        }

        Main.context.setUserId(id);
        Main.context.setUserType(Context.CLIENTE);
        Main.context.setLocadoraId(-1);

        return true;
    }

}
