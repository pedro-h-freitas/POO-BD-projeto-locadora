package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.views.menus.Menu;

public class MenuFuncionarioFilme extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioFilme() {
        this.controller = new FuncionarioController();
    }

    @Override
    public boolean render() {
        int op;

        System.out.println("--------------- Filmes ----------------");
        printOpcao("1", "Adicionar");
        printOpcao("2", "Remover");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        return false;
    }

}
