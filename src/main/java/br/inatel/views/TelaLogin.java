package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.LoginController;

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
        LoginController l = new LoginController();

        System.out.println("--------------- LOGIN -----------------");

        id = stringInput("Id: ");

        senha = stringInput("Senha: ");

        switch (l.login(id, senha)) {
            case 1:
//                System.out.println("Gerente");
//                System.out.println("ID: " + Main.context.getUserId());
                TelaGerente.render();
                break;
            case 2:
//                System.out.println("Cliente");
//                System.out.println("ID: " + Main.context.getUserId());
                TelaCliente telaCliente = new TelaCliente();
                telaCliente.render();
                break;
            case 3:
//                System.out.println("Funcionário");
//                System.out.println("ID: " + Main.context.getUserId());
                TelaFuncionario.render();
                break;
            case -1:
                printVermelho("""
                        !!!!! ID INVÁLIDO !!!!!
                        Aperte [ENTER] para continuar
                        """);
                Main.sc.nextLine();
                break;
            case -2:
                printVermelho("""
                        !!!!! SENHA INVÁLIDA !!!!!
                        Aperte [ENTER] para continuar
                        """);
                Main.sc.nextLine();
                break;
        }

        System.out.println("---------------------------------------");

        return true;
    }
}
