package br.inatel.views.menus.cliente;

import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.menus.Menu;

import java.util.ArrayList;

/**
 * Menu para Cliente alugar Filmes
 */
public class MenuClienteAluguel extends Menu {
    private ArrayList<FilmeDisplay> filmes;
    private ArrayList<FilmeDisplay> carrinho;
    private final ClienteController controller;

    public MenuClienteAluguel() {
        this.controller = new ClienteController();
    }

    /**
     * Exibe Menu para Cliente alugar Filmes
     */
    @Override
    public boolean render() {
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

            op = intInput();

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
            printVermelho("Carrinho vazio\n");
            return false;
        }

        controller.alugar(carrinho);
        printVerde("Filmes alugados: \n");
        printCarrinho();
        return true;
    }

    /**
     * Função auxiliar para exibir os filmes na tela
     */
    private void printFilmes() {
        System.out.print("--------------- Filmes ----------------");
        for (FilmeDisplay filme :
                filmes) {
            if (filme.getnDisponiveis() == 0) continue;

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

    /**
     * Função auxiliar para exibir o carrinho na tela
     */
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

    /**
     * Função auxiliar para adicionar filme ao carrinho
     * @param idFilme Filme que se deseja adicionar
     * @return Retorna o preço do filme
     */
    private int adicionaFilme(int idFilme) {
        for (FilmeDisplay filme :
                filmes) {
            if (filme.getId() == idFilme) {
                carrinho.add(filme);

                return filme.getPreco();
            }
        }
        printVermelho("Filme inválido\n");
        return 0;
    }

    /**
     * Função auxiliar para remover filme ao carrinho
     * @param idFilme Filme que se deseja remover
     * @return Retorna o preço do filme
     */
    private int removeFilme(int idFilme) {
        for (int i = 0; i < carrinho.size(); i++) {
            if (carrinho.get(i).getId() == idFilme)
                return carrinho.remove(i).getPreco();
        }
        printVermelho("Filme inválido\n");
        return 0;
    }

}