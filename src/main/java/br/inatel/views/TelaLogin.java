package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.LoginController;

/**
 * Tela de login, loga um cliente, funcionario ou gerente
 */
public class TelaLogin {
    /**
     * Exibe a Tela de Login
     * Chama Tela do Gerente
     * Chama Tela de Funcionario
     * Chama Tela de Cliente
     */
    public static void render() {
        String id, senha;
        LoginController l = new LoginController();

        System.out.println("--------------- LOGIN -----------------");

        System.out.print("Id: ");
        id = Main.sc.nextLine();

        System.out.print("Senha: ");
        senha = Main.sc.nextLine();

        switch (l.login(id, senha)) {
            case 1:
                System.out.println("Funcionário");
                System.out.println("ID: " + Main.context.getUserId());
                break;
            case 2:
                System.out.println("Cliente");
                break;
            case -1:
                System.out.println("ID INVÁLIDO");
                break;
            case -2:
                System.out.println("SENHA INVÁLIDA");
                break;
        }

        System.out.println("---------------------------------------");
    }
}
