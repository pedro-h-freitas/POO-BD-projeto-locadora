package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.models.Cliente;
import br.inatel.views.forms.clientes.FormDeletarCliente;
import br.inatel.views.menus.Menu;
import br.inatel.views.Tela;
import br.inatel.views.forms.clientes.FormCadastroCliente;
import br.inatel.views.forms.clientes.FormEditarCliente;

import java.util.ArrayList;

/**
 * Menu para o funcionario manipular cliente
 */
public class MenuFuncionarioCliente extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioCliente() {
        this.controller = new FuncionarioController();
    }

    /**
     * Exibe Menu do Gerente para manipular Funcionarios
     * Chama Form de cadastro de cliente
     * Chama Form de edição de cliente
     * Chama Form de deleção de cliente
     * @return boolean var (true: roda novamente | false: logout)
     */
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

                tela = new FormDeletarCliente(idCliente);
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
     * Função auxiliar para mostrar na tela a lista de clientes
     * @return Lista com os ids dos clientes
     */
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

    /**
     * Função auxiliar para escolher um cliente
     * @return Id do cliente escolhido
     */
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

}
