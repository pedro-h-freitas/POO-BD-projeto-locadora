package br.inatel.views.cliente;

import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.Menu;

import java.util.ArrayList;

public class MenuFilmesAlugados extends Menu {
    @Override
    public boolean render() {
        // TODO ver data de locacao e calcular atraso caso haja

        int op;

        ClienteController controller = new ClienteController();
        int idAluguel = controller.getIdAluguel();
        ArrayList<FilmeDisplay> filmes = controller.getFilmesByAluguel(idAluguel);

        System.out.println("------------ Filmes Alugados ----------");
        for (int i = 0; i < filmes.size(); i++) {
            FilmeDisplay filme = filmes.get(i);

            String id = Integer.toString(i);
            String ano = Integer.toString(filme.getAno());

            printVerde(id);
            System.out.print(" - ");
            printAmarelo(filme.getNome() + " (" + ano + ")");
            System.out.println();
        }
        System.out.println("---------------------------------------");
        printOpcao("1", "Devoler Filmes");
        printOpcao("0", "Voltar");
        System.out.println("---------------------------------------");

        while (true){
            op = intInput("Opção: ");

            switch (op){
                case 1:
                    controller.devolverFilmes(idAluguel);
                    printVerde("Filmes devolvidos\n");
                    return true;
                case 0:
                    return true;
                default:
                    printOpcaoInvalida();
                    break;
            }

        }
    }
}
