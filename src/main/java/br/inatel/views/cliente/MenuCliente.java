package br.inatel.views.cliente;

import br.inatel.Main;
import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.Locadora;
import br.inatel.views.Menu;
import br.inatel.views.Tela;

import java.util.ArrayList;

/**
 * Tela do Cliente
 */
public class MenuCliente extends Menu {

    /**
     * Mostra Tela do Cliente
     */
    public boolean render() {
        //TODO
        ClienteController controller = new ClienteController();
        int op;

        Tela tela;

        if (Main.context.getLocadoraId() == -1) {
            ArrayList<Locadora> locadoras = controller.selectAllLocadoras();
            ArrayList<Integer> idList = new ArrayList<>();

            System.out.println("---------------------------------------");
            printAzul("Qual locadora você está?\n");
            System.out.print("---------------------------------------");

            for (Locadora l :
                    locadoras) {
                idList.add(l.getId());

                System.out.println();
                printVerde(l.getId()+"");
                System.out.print(" - ");
                printAmarelo(l.getNome() + "\n");
                printCiano("Cidade: " + l.getCidade());
                System.out.println();
            }
            System.out.println("---------------------------------------");

            int idLocadora = inputIdLocadora(idList);
            Main.context.setLocadoraId(idLocadora);
        }

        printMenu(controller);

        op = intInput("Opção: ");

        tela = null;
        switch (op) {
            case 1:
                if (controller.hasAluguel()) printVermelho("Você já possui filmes alugados\n");
                else tela = new MenuClienteAluguel();
                break;
            case 2:
                if (!controller.hasAluguel()) printVermelho("Você não possui filmes alugados\n");
                else tela = new MenuClienteFilmesAlugados();
                break;
            case 3:
                Main.context.setLocadoraId(-1);
                break;
            case 4:
                return !deleteUser(controller);
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
     * Método auxiliar para realizar o input do ID da locadora
     * @param idList Lista de IDs válidos
     * @return valor inputado
     */
    private int inputIdLocadora(ArrayList<Integer> idList) {
        int id;

        id = intInput("Id: ");
        if (!idList.contains(id)) {
            printVermelho("ID INVÁLIDO");
            id = intInput("Id: ");
        }

        return id;
    }

    private void printMenu(ClienteController controller) {
        String nomeCliente;
        String nomeLocadora;

        nomeCliente = controller.getNomeCliente();
        nomeLocadora = controller.getNomeLocadora();

        System.out.println("------------- Infos Seção -------------");
        printCiano("ID: " + Main.context.getUserId() + "\n");
        printCiano("Nome: " + nomeCliente + "\n");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n---------------------------------------");
        System.out.println("------------ Menu Cliente -------------");
        printOpcao("1", "Alugar filmes");
        printOpcao("2", "Mostrar filmes alugados");
        printOpcao("3", "Trocar locadora");
        printOpcao("4", "Deletar conta");
        printOpcao("0", "Logout");
        System.out.println("---------------------------------------");
    }

    private boolean deleteUser(ClienteController controller) {
        if (controller.hasAluguel()) {
            printVermelho("Há aluguéis pendentes\n");
            return false;
        }

        printAmarelo("Você tem crtz??");
        String s;
        do {
            s = stringInput("(S/N) ").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));
        if (s.equals("s")) {
            controller.deleteUser();
            return true;
        }

        return false;
    }
}