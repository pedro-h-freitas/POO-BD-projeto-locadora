package br.inatel.views.cliente;

import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.FilmeAlugar;
import br.inatel.views.Menu;

import java.util.ArrayList;

public class MenuAlugar extends Menu {
    private ArrayList<FilmeAlugar> filmes;
    private ArrayList<FilmeAlugar> carrinho;

    @Override
    public boolean render() {
        ClienteController controller = new ClienteController();

        filmes = controller.getFilmes();
        carrinho = new ArrayList<>();

        boolean run = true;

        boolean showAdicionaCarrinho = true;
        boolean showRemoveCarrinho = false;
        boolean showMenu = true;

        int total = 0;
        int op;
        while (run) {

            if (showAdicionaCarrinho) {
                printFilmes();

                printVerde("0");
                System.out.print(" - ");
                printAmarelo("Encerrar\n");

                while (true) {
                    op = intInput("Adicionar ao carrinho: ");

                    if (op == 0) break;

                    total += adicionaFilme(op);
                }

                showAdicionaCarrinho = false;
            }

            if (showRemoveCarrinho) {
                printCarrinho();

                printVerde("0");
                System.out.print(" - ");
                printAmarelo("Encerrar\n");

                while (true) {
                    op = intInput("Remover do carrinho: ");

                    if (op == 0) break;

                    total -= removeFilme(op);
                }

                showRemoveCarrinho = false;
            }

            if (showMenu) {
                printCarrinho();
                System.out.println("Total = R$" + total + ",00");
                System.out.println("---------------------------------------");
                printOpcao("1", "Remover filme(s)");
                printOpcao("2", "Adicionar filme(s)");
                printOpcao("0", "Concluir");
                System.out.println("---------------------------------------");

                showMenu = false;
            }

            op = intInput("Opção: ");

            switch (op) {
                case 1:
                    showMenu = true;
                    showRemoveCarrinho = true;
                    break;
                case 2:
                    showMenu = true;
                    showAdicionaCarrinho = true;
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    printOpcaoInvalida();
                    break;
            }
        }

        if (filmes.isEmpty())
            return false;

        controller.alugar(filmes);
        return true;
    }

    private void printFilmes() {
        System.out.println("--------------- Filmes ----------------");
        for (FilmeAlugar filme :
                filmes) {
            String id = Integer.toString(filme.getId());
            String ano = Integer.toString(filme.getAno());

            printVerde(id);
            System.out.print(" - ");
            printAmarelo(filme.getNome() + " (" + ano + ")");
            System.out.print("\n\tGeneros: " + filme.getGeneros());
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    private void printCarrinho() {
        System.out.println("-------------- Carrinho ---------------");
        for (FilmeAlugar filme :
                carrinho) {
            String id = Integer.toString(filme.getId());
            String ano = Integer.toString(filme.getAno());

            printOpcao(id, filme.getNome() + " (" + ano + ")");
        }
        System.out.println("---------------------------------------");
    }

    private int adicionaFilme(int op) {
        for (FilmeAlugar filme :
                filmes) {
            if (filme.getId() == op) {
                carrinho.add(filme);

                return filme.getPreco();
            }
        }
        printVermelho("Filme inválido\n");
        return 0;
    }

    private int removeFilme(int op) {
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getId() == op)
                return carrinho.remove(i).getPreco();
        }
        printVermelho("Filme inválido\n");
        return 0;
    }

}