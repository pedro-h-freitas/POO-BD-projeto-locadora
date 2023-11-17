package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Gerente
 */
public class TelaGerente {
    /**
     * Mostra Menu do Gerente
     */
    public static void render() {
        //TODO
        System.out.println("Gerente Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();
    }
}