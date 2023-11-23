package br.inatel.views.forms;

public class FormFilmeRemoveBanco extends FormFilme {
    private final int idFilme;

    public FormFilmeRemoveBanco(int idFilme) {
        super();
        this.idFilme = idFilme;
    }

    @Override
    public boolean render() {
        System.out.println("--------------- REMOVER ---------------");
        System.out.println("  ---------- Banco de Dados ---------  ");
        return false;
    }
}
