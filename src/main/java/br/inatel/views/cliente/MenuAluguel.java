package br.inatel.views.cliente;

import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.Menu;

import java.util.ArrayList;

public class MenuAluguel extends Menu {
    private ArrayList<FilmeDisplay> filmes;
    private ArrayList<FilmeDisplay> carrinho;

    @Override
    public boolean render() {
        ClienteController controller = new ClienteController();

        filmes = controller.getFilmesByLocadora();
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

        if (carrinho.isEmpty()){
            printVermelho("Carrinho vazio");
            return false;
        }

        controller.alugar(carrinho);
        printVerde("Filmes alugados: \n");
        printCarrinho();
        return true;
    }

    private void printFilmes() {
        System.out.print("--------------- Filmes ----------------");
        for (FilmeDisplay filme :
                filmes) {
            String id = Integer.toString(filme.getId());
            String ano = Integer.toString(filme.getAno());

            System.out.println();
            printVerde(id);
            System.out.print(" - ");
            printAmarelo(filme.getNome() + " (" + ano + ")");
            printCiano("\nGeneros: " + filme.getGeneros());
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    private void printCarrinho() {
        System.out.println("-------------- Carrinho ---------------");
        for (FilmeDisplay filme :
                carrinho) {
            String id = Integer.toString(filme.getId());
            String ano = Integer.toString(filme.getAno());

            printOpcao(id, filme.getNome() + " (" + ano + ")");
        }
        System.out.println("---------------------------------------");
    }

    private int adicionaFilme(int op) {
        for (FilmeDisplay filme :
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