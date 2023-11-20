package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.userController.FuncionarioController;

/**
 * Tela do Funcionario
 */
public class MenuFuncionario extends Menu {
    /**
     * Mostra Tela do Funcionario
     */
    public boolean render() {
        //TODO
        FuncionarioController controller = new FuncionarioController();
        String nomeLocadora;
        int op;

        nomeLocadora = controller.getNomeLocadora();

        System.out.println("=======================================");
        printCiano("ID Funcionario Logado: " + Main.context.getUserId());
        System.out.println("\n=======================================");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n=======================================");
        System.out.println("---------- Menu Funcionario -----------");
        printOpcao("1", "Clientes \n\t (Criar, Editar, Deletar)");
        printOpcao("2", "Filmes \n\t (Adicionar, Remover)");
        printOpcao("3", "Alugueis \n\t (Criar, Dar Baixa)");
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