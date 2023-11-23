package br.inatel.views.forms;

public class FormFilmeAddBanco extends FormFilme {
    private final int idInfoFilme;

    public FormFilmeAddBanco(int idInfoFilme) {
        super();
        this.idInfoFilme = idInfoFilme;
    }

    @Override
    public boolean render() {
        System.out.println("FormFilmeAddBanco");
        return false;
    }
}
