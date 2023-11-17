package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Cliente
 */
public class TelaCliente extends Tela{

    /**
     * Mostra Tela do Cliente
     */
    public boolean render() {
        //TODO
        System.out.println("Cliente Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();

        return true;
    }
}