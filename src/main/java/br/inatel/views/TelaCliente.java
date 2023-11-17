package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Cliente
 */
public class TelaCliente {

    /**
     * Mostra Menu do Cliente
     */
    public static void render() {
        //TODO
        System.out.println("Cliente Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();
    }
}