package br.inatel.views.menus.gerente;

import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionarioFilme;

public class MenuGerenteFilme extends Menu {
    @Override
    public boolean render() {
        return new MenuFuncionarioFilme().render();
    }
}
