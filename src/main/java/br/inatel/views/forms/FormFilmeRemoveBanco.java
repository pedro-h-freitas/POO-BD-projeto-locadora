package br.inatel.views.forms;

import br.inatel.models.FilmeDisplay;

import java.util.ArrayList;

public class FormFilmeRemoveBanco extends FormFilme {
    private final int idInfoFilme;

    public FormFilmeRemoveBanco(int idInfoFilme) {
        super();
        this.idInfoFilme = idInfoFilme;
    }

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
            controller.deleteInfoFilme(idInfoFilme);
            return true;
        }

        return false;
    }
}
