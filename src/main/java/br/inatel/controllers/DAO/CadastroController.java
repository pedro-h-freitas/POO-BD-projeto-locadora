package br.inatel.controllers.DAO;

import br.inatel.Main;
import br.inatel.controllers.Context;
import br.inatel.models.Cliente;

public class CadastroController {
    public boolean cadastro(
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

       if (id == -1)
           return false;

       Main.context.setUserId(id);
       Main.context.setUserType(Context.CLIENTE);
       Main.context.setLocadoraId(-1);

        return true;
    }

}
