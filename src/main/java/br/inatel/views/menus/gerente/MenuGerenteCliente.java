package br.inatel.views.menus.gerente;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.models.Cliente;
import br.inatel.views.Tela;
import br.inatel.views.forms.clientes.FormCadastroCliente;
import br.inatel.views.forms.clientes.FormDeletarCliente;
import br.inatel.views.forms.clientes.FormEditarCliente;
import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionarioCliente;

import java.util.ArrayList;

public class MenuGerenteCliente extends Menu {
    @Override
    public boolean render() {
        return new MenuFuncionarioCliente().render();
    }
}
