package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.views.menus.Menu;

public class MenuFuncionarioAluguel extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioAluguel() {
        this.controller = new FuncionarioController();
    }

    @Override
    public boolean render() {
        int op;

        System.out.println("-------------- Alugueis ---------------");
        printOpcao("1", "Criar");
        printOpcao("2", "Dar Baixa");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        return false;
    }
}
