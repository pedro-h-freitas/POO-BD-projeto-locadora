package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Funcionario
 */
public class TelaFuncionario {
    /**
     * Mostra Tela do Funcionario
     */
    public static void render() {
        //TODO
        System.out.println("Funcionario Logado");
        System.out.println("ID: " + Main.context.getUserId());
        Main.sc.nextLine();
    }
}