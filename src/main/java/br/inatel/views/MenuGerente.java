package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.userController.GerenteController;

/**
 * Tela do Gerente
 */
public class MenuGerente extends Menu {
    /**
     * Mostra Tela do Gerente
     */
    public boolean render() {
        //TODO
        GerenteController controller = new GerenteController();
        String nomeLocadora;
        int op;

        nomeLocadora = controller.getNomeLocadora();

        System.out.println("Gerente Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();
        System.out.println("=======================================");
        printCiano("ID Gerente Logado: " + Main.context.getUserId());
        System.out.println("\n=======================================");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n=======================================");
        System.out.println("------------ Menu Gerente -------------");
        printOpcao("1", "Clientes \n\t(Criar, Editar, Deletar)");
        printOpcao("1", "Funcionario \n\t(Criar, Editar, Deletar, Dar Aumento, Transferir)");
        printOpcao("2", "Filmes \n\t(Adicionar, Remover)");
        printOpcao("3", "Alugueis \n\t(Criar, Dar Baixa)");
        printOpcao("0", "Logout");
        System.out.println("---------------------------------------");

        op = intInput("Opção: ");

        switch (op) {
            case 1:
                System.out.println("Clientes");
                break;
            case 2:
                System.out.println("Filmes");
                break;
            case 3:
                System.out.println("Alugueis");
                return false;
            case 0:
                System.out.println("logout");
                return false;
            default:
                printOpcaoInvalida();
                break;
        }

        return true;
    }
}