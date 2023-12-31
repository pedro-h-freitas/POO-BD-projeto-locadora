package br.inatel.views.forms.filmes;

import br.inatel.Main;
import br.inatel.models.FilmeDisplay;

/**
 * Form para adicionar um filme a locadora
 */
public class FormAddFilmeLocadora extends FormFilme {
    private final int idInfoFilme;

    public FormAddFilmeLocadora(int idInfoFilme) {
        super();
        this.idInfoFilme = idInfoFilme;
    }

    /**
     * Mostrar Form para adicionar um filme a locadora
     */
    @Override
    public boolean render() {
        String idFilmeAux = "" + Main.context.getLocadoraId() + idInfoFilme;
        int idFilme = Integer.parseInt(idFilmeAux);

        FilmeDisplay filme = controller.getFilmeById(idFilme);

        System.out.println("-------------- ADICIONAR --------------");
        System.out.println("  ------------- Locadora ------------  ");

        if (filme == null)
            printAmarelo("Nenhuma cópia na locadora.");
        else
            showFilme(filme);

        System.out.println("\n---------------------------------------");

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
