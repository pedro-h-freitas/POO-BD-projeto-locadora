package br.inatel.views.menus.funcionario;

import br.inatel.controllers.userController.FuncionarioController;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.Tela;
import br.inatel.views.forms.filmes.FormAddFilmeBanco;
import br.inatel.views.forms.filmes.FormAddFilmeLocadora;
import br.inatel.views.forms.filmes.FormRemoveFilmeBanco;
import br.inatel.views.forms.filmes.FormRemoveFilmeLocadora;
import br.inatel.views.menus.Menu;

import java.util.ArrayList;

public class MenuFuncionarioFilme extends Menu {
    private final FuncionarioController controller;

    public MenuFuncionarioFilme() {
        this.controller = new FuncionarioController();
    }

    @Override
    public boolean render() {
        Tela tela;
        int op;

        System.out.println("--------------- Filmes ----------------");
        System.out.println("  ------------ Locadora -------------  ");
        printOpcao("  1", "Listar filmes");
        printOpcao("  2", "Adicionar filme");
        printOpcao("  3", "Remover filme");
        System.out.println("  --------- Banco de Dados ----------  ");
        printOpcao("  4", "Listar filmes");
        printOpcao("  5", "Adicionar filme");
        printOpcao("  6", "Remover filme");
        System.out.println("---------------------------------------");
        printOpcao("0", "Sair");
        System.out.println("---------------------------------------");

        op = intInput();

        tela = null;
        int idFilme;
        switch (op) {
            case 1:
                listarFilmesLocadora();
                break;
            case 2:
                idFilme = escolherFilmeBanco();
                if (idFilme == 0) break;

                tela = new FormAddFilmeLocadora(idFilme);
                break;
            case 3:
                idFilme = escolherFilmeLocadora();
                if (idFilme == 0) break;

                tela = new FormRemoveFilmeLocadora(idFilme);
                break;
            case 4:
                listarFilmesBanco();
                break;
            case 5:
                tela = new FormAddFilmeBanco();
                break;
            case 6:
                idFilme = escolherFilmeBanco();
                if (idFilme == 0) break;

                tela = new FormRemoveFilmeBanco(idFilme);
                break;
            case 0:
                return false;
            default:
                break;
        }

        if (tela != null) tela.render();

        return true;
    }

    private void showFilme(FilmeDisplay filme) {
        printOpcao(filme.getId()+"", filme.getNome() + " (" + filme.getAno() + ")");
        if (filme.getnCopias() != -1) {
            printCiano("\tCopias:\t\t " + filme.getnCopias() + "\n");
            printCiano("\tDisponiveis: " + filme.getnDisponiveis() + "\n");
            System.out.println();
        }
    }

    private ArrayList<Integer> listaFilmes(ArrayList<FilmeDisplay> filmes) {
        ArrayList<Integer> listaId = new ArrayList<>();

        System.out.println("------------ Lista Filmes -------------");
        for (FilmeDisplay filme :
                filmes) {
            listaId.add(filme.getId());
            showFilme(filme);
        }
        System.out.println("---------------------------------------");

        return listaId;
    }

    private ArrayList<Integer> listarFilmesLocadora() {
        ArrayList<FilmeDisplay> filmes = controller.getFilmesByLocadora();
        return listaFilmes(filmes);
    }

    private ArrayList<Integer> listarFilmesBanco() {
        ArrayList<FilmeDisplay> filmes = controller.getFilmesInfos();
        return listaFilmes(filmes);
    }

    private int escolherFilme(ArrayList<Integer> listaId) {
        int idFilme;

        listaId.add(0);
        printOpcao("0", "Cancelar");
        System.out.println("---------------------------------------");

        while (true) {
            idFilme = intInput("Id: ");
            if (listaId.contains(idFilme)) break;

            printVermelho("Id inválido\n");
        }

        return idFilme;
    }

    private int escolherFilmeLocadora() {
        ArrayList<Integer> listaId = listarFilmesLocadora();
        return escolherFilme(listaId);
    }

    private int escolherFilmeBanco() {
        ArrayList<Integer> listaId = listarFilmesBanco();
        return escolherFilme(listaId);
    }

/*
    private void deleteFilmeBanco(int idFilme) {
        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");
        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));
        if (s.equals("s")) {
            controller.deleteFilmeBanco(idFilme);
        }
    }*/
}
