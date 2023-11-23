package br.inatel.views.forms;

import br.inatel.models.FilmeDisplay;

import java.util.ArrayList;

public class FormFilmeAddBanco extends FormFilme {
    @Override
    public boolean render() {
        String nome;
        int ano;
        ArrayList<String> generosList = new ArrayList<>();
        String generoAux;

        System.out.println("-------------- ADICIONAR --------------");
        nome = stringInput("Nome: ");
        ano = intInput("Ano de lançamento: ");
        generoAux = stringInput("Genero: ");
        while (!generoAux.isEmpty()) {
            generosList.add(generoAux);
            generoAux = stringInput("[ENTER] para parar\nGenero: ");
        }
        System.out.println("---------------------------------------");

        String generos = String.join(",", generosList);
        FilmeDisplay filme = new FilmeDisplay(nome, ano, generos);

        int idInfoFilme = controller.adicionaFilmeBanco(filme);

        printVerde("Filme: ");
        printVermelho(nome);
        printVerde(" adiocionado com sucesso");
        printVerde("Id: ");
        printVermelho(idInfoFilme + "\n");

        return true;
    }
}
