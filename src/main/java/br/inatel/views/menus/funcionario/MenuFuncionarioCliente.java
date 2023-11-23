package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.models.Cliente;
import br.inatel.views.menus.Menu;
import br.inatel.views.Tela;
import br.inatel.views.forms.FormCadastroCliente;
import br.inatel.views.forms.FormEditarCliente;

import java.util.ArrayList;

public class MenuFuncionarioCliente extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioCliente() {
        this.controller = new FuncionarioController();
    }

    @Override
    public boolean render() {
        Tela tela;
        int op;

        System.out.println("-------------- Clientes ---------------");
        printOpcao("1", "Listar");
        printOpcao("2", "Criar");
        printOpcao("3", "Editar");
        printOpcao("4", "Deletar");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        int idCliente;
        switch (op) {
            case 1:
                listarClientes();
                break;
            case 2:
                tela = new FormCadastroCliente();
                break;
            case 3:
                idCliente = escolherCliente();
                if (idCliente == 0) break;

                tela = new FormEditarCliente(idCliente);
                break;
            case 4:
                idCliente = escolherCliente();
                if (idCliente == 0) break;

                deleteUser(idCliente);
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

    private ArrayList<Integer> listarClientes() {
        ArrayList<Cliente> clientes = controller.getAllClientes();
        ArrayList<Integer> listaId = new ArrayList<>();

        System.out.println("---------------------------------------");
        for (Cliente c :
                clientes) {
            listaId.add(c.getId());

            printOpcao(c.getId() + "", c.getNome() + " (" + c.getCpf() + ")");
        }
        System.out.println("---------------------------------------");

        return listaId;
    }

    private int escolherCliente() {
        int idCliente;
        ArrayList<Integer> listaId = listarClientes();

        listaId.add(0);
        printOpcao("0", "Cancelar");
        System.out.println("---------------------------------------");

        while (true) {
            idCliente = intInput("Id: ");
            if (listaId.contains(idCliente)) break;

            printVermelho("Id inválido\n");
        }

        return idCliente;
    }

    private void deleteUser(int idCliente) {
        if (controller.hasAluguel(idCliente)) {
            printVermelho("Há aluguéis pendentes\n");
            return;
        }

        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");
        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));
        if (s.equals("s")) {
            controller.deleteCliente(idCliente);
        }
    }
}
