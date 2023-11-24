package br.inatel.views.menus.gerente;

import br.inatel.Main;
import br.inatel.controllers.userController.GerenteController;
import br.inatel.views.Tela;
import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionarioCliente;
import br.inatel.views.menus.funcionario.MenuFuncionarioFilme;

/**
 * Tela do Gerente
 */
public class MenuGerente extends Menu {
    private final GerenteController controller;

    public MenuGerente() {
        this.controller = new GerenteController();
    }

    /**
     * Mostra Tela do Gerente
     */
    public boolean render() {
        //TODO
        Tela tela;
        String nomeLocadora;
        String nomeGerente;
        int op;

        nomeLocadora = controller.getNomeLocadora();

        nomeGerente = controller.getNomeFuncionario();
        nomeLocadora = controller.getNomeLocadora();

        System.out.println("------------- Infos Seção -------------");
        printCiano("ID: " + Main.context.getUserId() + "\n");
        printCiano("Nome: " + nomeGerente + "\n");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n---------------------------------------");
        System.out.println("------------ Menu Gerente -------------");
        printOpcao("1", "Clientes \n\t(Criar, Editar, Deletar)");
        printOpcao("2", "Funcionario \n\t(Criar, Editar, Deletar, Dar Aumento, Transferir)");
        printOpcao("3", "Filmes \n\t(Adicionar, Remover)");
        printOpcao("0", "Logout");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        switch (op) {
            case 1:
                tela = new MenuFuncionarioCliente();
                break;
            case 2:
                System.out.println("Funcionarios");
                break;
            case 3:
                tela = new MenuFuncionarioFilme();
                break;
            case 0:
                System.out.println("logout");
                return false;
            default:
                printOpcaoInvalida();
                break;
        }

        if (tela != null) {
            boolean run = true;
            while (run) {
                run = tela.render();
            }
        }

        return true;
    }
}