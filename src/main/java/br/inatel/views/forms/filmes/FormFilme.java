package br.inatel.views.forms.filmes;

import br.inatel.models.FilmeDisplay;
import br.inatel.views.forms.Form;

public abstract class FormFilme extends Form {
    protected void showFilme(FilmeDisplay filme) {
        printVerde(filme.getId()+"");
        System.out.print(" - ");
        printAmarelo(filme.getNome() + " (" + filme.getAno() + ")\n");
        if (filme.getnCopias() != -1) {
            printCiano("\tCopias:\t\t " + filme.getnCopias() + "\n");
            printCiano("\tDisponiveis: " + filme.getnDisponiveis());
        }
    }
}
