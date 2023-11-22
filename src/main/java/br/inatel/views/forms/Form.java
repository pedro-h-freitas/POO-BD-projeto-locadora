package br.inatel.views.forms;

import br.inatel.controllers.FormsController;
import br.inatel.views.Tela;

public abstract class Form extends Tela {
    protected final FormsController controller;

    public Form() {
        this.controller = new FormsController();
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    protected String inputCampoObrigatorio(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + ": ");
        while (campo.isEmpty()) {
            printVermelho("CAMPO OBRIGATÓRIO\n");

            campo = stringInput(nomeCampo + ": ");
        }

        return campo;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    protected String inputCampoOpcional(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + " (opcional): ");
        if (campo.isEmpty()) {
            campo = null;
        }

        return campo;
    }
}
