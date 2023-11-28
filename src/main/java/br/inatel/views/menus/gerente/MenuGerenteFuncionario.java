package br.inatel.views.menus.gerente;

import br.inatel.controllers.userController.GerenteController;
import br.inatel.models.Funcionario;
import br.inatel.views.Tela;
import br.inatel.views.forms.funcionarios.*;
import br.inatel.views.menus.Menu;

import java.util.ArrayList;

/**
 * Menu para o gerente manipular funcionarios
 */
public class MenuGerenteFuncionario extends Menu {
    private final GerenteController controller;

    public MenuGerenteFuncionario() {
        this.controller = new GerenteController();
    }

    /**
     * Exibe Menu do Gerente para manipular Funcionarios
     * Chama Form de cadastro de funcionario
     * Chama Form de edição de funcionario
     * Chama Form de aumento do salario de funcionario
     * Chama Form de transferencia de funcionario
     * Chama Form de deleção de funcionario
     * @return boolean var (true: roda novamente | false: logout)
     */
    @Override
    public boolean render() {
        Tela tela;
        int op;

        System.out.println("------------ Funcionários -------------");
        printOpcao("1", "Listar");
        printOpcao("2", "Cadastrar");
        printOpcao("3", "Editar");
        printOpcao("4", "Dar Aumento");
        printOpcao("5", "Transferir");
        printOpcao("6", "Deletar");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        int idFuncionario;
        switch (op) {
            case 1:
                listarFuncionario();
                break;
            case 2:
                tela = new FormCadastroFuncionario();
                break;
            case 3:
                idFuncionario = escolherFuncionario();
                if (idFuncionario == 0) break;

                tela = new FormEditarFuncionario(idFuncionario);
                break;
            case 4:
                idFuncionario = escolherFuncionario();
                if (idFuncionario == 0) break;

                tela = new FormAumentoFunionario(idFuncionario);
                break;
            case 5:
                idFuncionario = escolherFuncionario();
                if (idFuncionario == 0) break;

                tela = new FormTransferirFuncionario(idFuncionario);
                break;
            case 6:
                idFuncionario = escolherFuncionario();
                if (idFuncionario == 0) break;

                tela = new FormDeletarFuncionario(idFuncionario);
                break;
            case 0:
                return false;
            default:
                printOpcaoInvalida();
                break;
        }


        if (tela != null) tela.render();

        return true;
    }

    /**
     * Função auxiliar para mostrar na tela a lista de funcionario da locadora
     * @return Lista com os ids dos funcionário
     */
    private ArrayList<Integer> listarFuncionario() {
        ArrayList<Funcionario> funcionarios = controller.getAllFuncionarios();
        ArrayList<Integer> listaId = new ArrayList<>();

        System.out.println("---------------------------------------");
        for (Funcionario f :
                funcionarios) {
            listaId.add(f.getId());

            printOpcao(f.getId() + "", f.getNome());
        }
        System.out.println("---------------------------------------");

        return listaId;
    }

    /**
     * Função auxiliar para escolher um funcionario da locadora
     * @return Id do funcinário escolhido
     */
    private int escolherFuncionario() {
        int idFuncionario;
        ArrayList<Integer> listaId = listarFuncionario();

        listaId.add(0);
        printOpcao("0", "Cancelar");
        System.out.println("---------------------------------------");

        while (true) {
            idFuncionario = intInput("Id: ");
            if (listaId.contains(idFuncionario)) break;

            printVermelho("Id inválido\n");
        }

        return idFuncionario;
    }

}
