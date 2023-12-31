package br.inatel.views.forms.filmes;

import java.util.ArrayList;

/**
 * Form para remover informações de um filme no banco
 */
public class FormRemoveFilmeBanco extends FormFilme {
    private final int idInfoFilme;

    public FormRemoveFilmeBanco(int idInfoFilme) {
        super();
        this.idInfoFilme = idInfoFilme;
    }

    /**
     * Exibe Form para remover informações de um filme no banco
     */
    @Override
    public boolean render() {
        ArrayList<Integer> locadoras = controller.getLocadorasIdByInfoFilme(idInfoFilme);

        if (!locadoras.isEmpty()) {
            printVermelho("Este filme exista na(s) locadora(s): ");
            for (int i :
                    locadoras) {
                printVermelho(i + " ");
            }
            System.out.println();
            return false;
        }

        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");
        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));

        if (s.equals("s")) {
            controller.deleteFilmeBanco(idInfoFilme);
            return true;
        }

        return false;
    }
}
