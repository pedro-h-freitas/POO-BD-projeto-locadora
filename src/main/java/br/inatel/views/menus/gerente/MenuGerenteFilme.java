package br.inatel.views.menus.gerente;

import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionarioFilme;

/**
 * Menu para o gerente manipular filmes
 */
public class MenuGerenteFilme extends Menu {
    /**
     * Chama o render de MenuFuncionarioFilme
     * @return boolean var (true: roda novamente | false: logout)
     */
    @Override
    public boolean render() {
        return new MenuFuncionarioFilme().render();
    }
}
