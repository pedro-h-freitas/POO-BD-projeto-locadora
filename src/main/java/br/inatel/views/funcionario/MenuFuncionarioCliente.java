package br.inatel.views.funcionario;

import br.inatel.views.Menu;

public class MenuFuncionarioCliente extends Menu {
    @Override
    public boolean render() {
        int op;

        System.out.println("-------------- Clientes ---------------");
        printOpcao("1", "Criar");
        printOpcao("2", "Editar");
        printOpcao("3", "Deletar");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput("Opção ");

        return false;
    }
}
