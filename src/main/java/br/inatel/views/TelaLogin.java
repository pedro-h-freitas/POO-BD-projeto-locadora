package br.inatel.views;

import br.inatel.controllers.LoginController;
import br.inatel.views.cliente.MenuCliente;
import br.inatel.views.funcionario.MenuFuncionario;
import br.inatel.views.gerente.MenuGerente;

/**
 * Tela de login, loga um cliente, funcionario ou gerente
 */
public class TelaLogin extends Tela{
    /**
     * Exibe a Tela de Login
     * Chama Tela do Gerente
     * Chama Tela de Funcionario
     * Chama Tela de Cliente
     */
    public boolean render() {
        String id, senha;
        LoginController controller = new LoginController();

        Menu menu = null;
        boolean run = true;

        System.out.println("--------------- LOGIN -----------------");

        id = stringInput("Id: ");

        senha = stringInput("Senha: ");

        switch (controller.login(id, senha)) {
            case 1:
//                System.out.println("Gerente");
//                System.out.println("ID: " + Main.context.getUserId());
                menu = new MenuGerente();
                break;
            case 2:
//                System.out.println("Funcionário");
//                System.out.println("ID: " + Main.context.getUserId());
                menu = new MenuFuncionario();
                break;
            case 3:
//                System.out.println("Funcionário");
//                System.out.println("ID: " + Main.context.getUserId());
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
