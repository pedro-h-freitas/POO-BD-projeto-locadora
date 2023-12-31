package br.inatel.views.forms.filmes;

import br.inatel.models.FilmeDisplay;

/**
 * Form para remover um filme da locadora
 */
public class FormRemoveFilmeLocadora extends FormFilme {
    private final int idFilme;

    public FormRemoveFilmeLocadora(int idFilme) {
        super();
        this.idFilme = idFilme;
    }

    /**
     * Exibe Form para remover um filme da locadora
     */
    @Override
    public boolean render() {
        FilmeDisplay filme = controller.getFilmeById(idFilme);

        System.out.println("--------------- REMOVER ---------------");
        System.out.println("  ------------- Locadora ------------  ");
        showFilme(filme);
        System.out.println();
        System.out.println("---------------------------------------");

        int qnt = intInput("Remover quantas cópias? ");

        if (filme.getnCopias() - qnt < 0) {
            printVermelho("Numero de copias indisponiveis\n");
            return false;
        }

        if (filme.getnDisponiveis() - qnt < 0) {
            printVermelho("Filme está alugado\n");
            return false;
        }

        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");

        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));

        if (s.equals("s")) {
            switch (controller.deleteFilmeLocadora(filme, qnt)) {
                case 1:
                    printVerde("Filme: ");
                    printVermelho(idFilme + "");
                    printVerde(", deletado com sucesso\n");
                    return true;
                case 2:
                    printVerde("Removido ");
                    printVermelho(qnt + "");
                    printVerde(" cópias do filme: ");
                    printVermelho(idFilme + "");
                    printVerde(", com sucesso\n");
                    return true;
                case -1:
                    printVermelho("Falha ao remover filme");
                    break;
            }
        }

        return false;
    }

}
