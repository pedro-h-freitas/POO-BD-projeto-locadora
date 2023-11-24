package br.inatel.views.forms.filmes;

import br.inatel.Main;
import br.inatel.models.FilmeDisplay;

public class FormAddFilmeLocadora extends FormFilme {
    private final int idInfoFilme;

    public FormAddFilmeLocadora(int idInfoFilme) {
        super();
        this.idInfoFilme = idInfoFilme;
    }

    @Override
    public boolean render() {
        String idFilmeAux = "" + Main.context.getLocadoraId() + idInfoFilme;
        int idFilme = Integer.parseInt(idFilmeAux);

        FilmeDisplay filme = controller.getFilmeById(idFilme);

        System.out.println("-------------- ADICIONAR --------------");
        System.out.println("  ------------- Locadora ------------  ");

        if (filme == null)
            printAmarelo("Nenhuma cópia na locadora.\n");
        else
            showFilme(filme);

        System.out.println("---------------------------------------");

        int qnt = intInput("Adicionar quantas cópias? ");

        if (controller.adicionaFilmeLocadora(idInfoFilme, qnt) == -1) {
            printVermelho("Falha ao adicionar filme");
            return false;
        }

        printVerde("Adicionado ");
        printVermelho(qnt + "");
        printVerde(" cópias do filme: ");
        printVermelho(idFilme + "");
        printVerde(", com sucesso\n");

        return true;
    }

}
