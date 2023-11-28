package br.inatel.views.menus.gerente;

import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionarioCliente;

import java.util.ArrayList;

/**
 * Menu para o gerente manipular clientes
 */
public class MenuGerenteCliente extends Menu {
    /**
     * Chama o render de MenuFuncionarioCliente
     * @return boolean var (true: roda novamente | false: logout)
     */
    @Override
    public boolean render() {
        return new MenuFuncionarioCliente().render();
    }
}
