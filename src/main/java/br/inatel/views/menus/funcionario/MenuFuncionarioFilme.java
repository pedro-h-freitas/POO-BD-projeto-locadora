package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.views.Tela;
import br.inatel.views.menus.Menu;

public class MenuFuncionarioFilme extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioFilme() {
        this.controller = new FuncionarioController();
    }

    @Override
    public boolean render() {
        Tela tela;
        int op;

        System.out.println("--------------- Filmes ----------------");
        System.out.println("  ------------ Locadora -------------  ");
        printOpcao("  1", "Listar filmes");
        printOpcao("  2", "Adicionar filme");
        printOpcao("  3", "Remover filme");
        System.out.println("  --------- Banco de Dados ----------  ");
        printOpcao("  4", "Listar filmes");
        printOpcao("  5", "Adicionar filme");
        printOpcao("  6", "Remover filme");
        System.out.println("---------------------------------------");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        int idFilme;
        switch (op) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                listarFilmesBanco();
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                return false;
            default:
                break;
        }

        if (tela != null) tela.render();

        return true;
    }
    }

}
