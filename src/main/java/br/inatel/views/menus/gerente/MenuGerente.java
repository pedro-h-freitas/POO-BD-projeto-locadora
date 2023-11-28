package br.inatel.views.menus.gerente;

import br.inatel.Main;
import br.inatel.controllers.userController.GerenteController;
import br.inatel.views.Tela;
import br.inatel.views.menus.Menu;

/**
 * Menu do Gerente
 */
public class MenuGerente extends Menu {
    private final GerenteController controller;

    public MenuGerente() {
        this.controller = new GerenteController();
    }

    /**
     * Exibe Menu do Gerente
     * Chama Menu para manipular Clientes
     * Chama Menu para manipular Funcionarios
     * Chama Menu para manipular Filmes
     * @return boolean var (true: roda novamente | false: logout)
     */
    public boolean render() {
        Tela tela;
        String nomeLocadora;
        String nomeGerente;
        int op;

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
                tela = new MenuGerenteCliente();
                break;
            case 2:
                tela = new MenuGerenteFuncionario();
                break;
            case 3:
                tela = new MenuGerenteFilme();
                break;
            case 0:
                printVermelho("Logout...");
                controller.logout();
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