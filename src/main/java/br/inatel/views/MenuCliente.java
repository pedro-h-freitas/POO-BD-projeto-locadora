package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.Locadora;

import java.util.ArrayList;

/**
 * Tela do Cliente
 */
public class MenuCliente extends Menu{

    /**
     * Mostra Tela do Cliente
     */
    public boolean render() {
        //TODO
        ClienteController controller = new ClienteController();
        String nomeLocadora;
        int op;

        if (Main.context.getLocadoraId() == -1) {
            ArrayList<Locadora> locadoras = controller.selectAllLocadoras();
            ArrayList<Integer> idList = new ArrayList<>();

            printAzul("\nQual locadora você está?\n");
            System.out.println("---------------------------------------");

            for (Locadora l :
                    locadoras) {
                idList.add(l.getId());

                System.out.println(l);
                System.out.println("---------------------------------------");
            }

            int idLocadora = inputIdLocadora(idList);
            Main.context.setLocadoraId(idLocadora);
        }

        nomeLocadora = controller.getNomeLocadora();

        System.out.println("=======================================");
        printCiano("ID Cliente Logado: " + Main.context.getUserId());
        System.out.println("\n=======================================");
        printCiano("Locadora: " + nomeLocadora);
        System.out.println("\n=======================================");
        System.out.println("------------ Menu Cliente -------------");
        printOpcao("1", "Alugar filmes");
        printOpcao("2", "Mostrar alugueis ativos");
        printOpcao("3", "Trocar locadora");
        printOpcao("4", "Deletar conta");
        printOpcao("0", "Logout");
        System.out.println("---------------------------------------");

        op = intInput("Opção: ");

        switch (op) {
            case 1:
                System.out.println("Alugar Filmes");
                break;
            case 2:
                System.out.println("Mostrando os alugueis aqui mano");
                break;
            case 3:
                Main.context.setLocadoraId(-1);
                break;
            case 4:
                System.out.println("voce tem crtz??");
                return false;
            case 0:
                System.out.println("logout");
                return false;
            default:
                printOpcaoInvalida();
                break;
        }

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
}