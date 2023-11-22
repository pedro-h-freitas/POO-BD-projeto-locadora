package br.inatel.views.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.models.Cliente;
import br.inatel.views.Menu;
import br.inatel.views.Tela;
import br.inatel.views.forms.FormCadastroCliente;
import br.inatel.views.forms.FormDeletarCliente;
import br.inatel.views.forms.FormEditarCliente;

import java.util.ArrayList;

public class MenuFuncionarioCliente extends Menu {
    @Override
    public boolean render() {
        FuncionarioController controller = new FuncionarioController();
        Tela tela;
        int op;

        System.out.println("-------------- Clientes ---------------");
        printOpcao("1", "Criar");
        printOpcao("2", "Editar");
        printOpcao("3", "Deletar");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        int idCliente;
        switch (op) {
            case 1:
                tela = new FormCadastroCliente();
                break;
            case 2:
                idCliente = escolherCliente(controller);
                if (idCliente == 0) break;

                tela = new FormEditarCliente(idCliente);
                break;
            case 3:
                idCliente = escolherCliente(controller);
                if (idCliente == 0) break;

                tela = new FormDeletarCliente(idCliente);
                break;
            default:
                printOpcaoInvalida();
                break;
        }

        if (tela != null) tela.render();

        return false;
    }

    private int escolherCliente(FuncionarioController controller) {
        int idCliente;
        ArrayList<Cliente> clientes = controller.getAllClientes();
        ArrayList<Integer> listaId = new ArrayList<>();

        System.out.println("---------------------------------------");
        for (Cliente c :
                clientes) {
            listaId.add(c.getId());

            printOpcao(c.getId() + "", c.getNome() + " (" + c.getCpf() + ")");
        }
        printOpcao("0", "Cancelar");
        listaId.add(0);
        System.out.println("---------------------------------------");

        while (true) {
            idCliente = intInput("Id: ");
            if (listaId.contains(idCliente)) break;

            printVermelho("Id inválido\n");
        }

        return idCliente;
    }
}
