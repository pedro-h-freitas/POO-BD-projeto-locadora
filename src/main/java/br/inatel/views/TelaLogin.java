package br.inatel.views;

import br.inatel.controllers.LoginController;
import br.inatel.views.menus.cliente.MenuCliente;
import br.inatel.views.menus.funcionario.MenuFuncionario;
import br.inatel.views.menus.gerente.MenuGerente;
import br.inatel.views.menus.Menu;

/**
 * Tela de login
 */
public class TelaLogin extends Tela{
    private final LoginController controller;

    public TelaLogin() {
        controller = new LoginController();
    }

    /**
     * Exibe a Tela de Login
     * Chama Tela do Gerente
     * Chama Tela de Funcionario
     * Chama Tela de Cliente
     */
    public boolean render() {
        String id, senha;

        Menu menu = null;
        boolean run = true;

        System.out.println("---------------- LOGIN ----------------");

        id = stringInput("Id: ");

        senha = stringInput("Senha: ");

        switch (controller.login(id, senha)) {
            case 1:
                menu = new MenuGerente();
                break;
            case 2:
                menu = new MenuFuncionario();
                break;
            case 3:
                menu = new MenuCliente();
                break;
            case -1:
                printVermelho("ID inválido\n");
                break;
            case -2:
                printVermelho("Senha inválida\n");
                break;
        }

        if (menu != null) {
            while (run) {
                run = menu.render();
            }
        }

        System.out.println("---------------------------------------");

        return true;
    }
}
