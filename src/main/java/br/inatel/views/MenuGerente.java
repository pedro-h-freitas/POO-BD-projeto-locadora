package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Gerente
 */
public class MenuGerente extends Menu {
    /**
     * Mostra Tela do Gerente
     */
    public boolean render() {
        //TODO
        System.out.println("Gerente Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();

        return true;
    }
}