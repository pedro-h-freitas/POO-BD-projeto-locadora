package br.inatel.views.funcionario;

import br.inatel.Main;
import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.views.Menu;
import br.inatel.views.Tela;

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
        String nomeFuncionario;
        String nomeLocadora;
        int op;

        Tela tela;

        nomeFuncionario = controller.getNomeFuncionario();
        nomeLocadora = controller.getNomeLocadora();

        System.out.println("------------- Infos Seção -------------");
        printCiano("ID: " + Main.context.getUserId() + "\n");
        printCiano("Nome: " + nomeFuncionario + "\n");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n---------------------------------------");
        System.out.println("---------- Menu Funcionario -----------");
        printOpcao("1", "Clientes \n\t(Criar, Editar, Deletar)");
        printOpcao("2", "Filmes \n\t(Adicionar, Remover)");
        printOpcao("3", "Alugueis \n\t(Criar, Dar Baixa)");
        printOpcao("0", "Logout");
        System.out.println("---------------------------------------");

        op = intInput("Opção: ");

        tela = null;
        switch (op) {
            case 1:
                tela = new MenuFuncionarioCliente();
                break;
            case 2:
                tela = new MenuFuncionarioFilme();
                break;
            case 3:
                tela = new MenuFuncionarioAluguel();
                break;
            case 0:
                System.out.println("logout");
                return false;
            default:
                printOpcaoInvalida();
                break;
        }

        if (tela != null) tela.render();

        return true;
    }
}