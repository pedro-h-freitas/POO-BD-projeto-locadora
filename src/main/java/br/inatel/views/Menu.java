package br.inatel.views;

import br.inatel.views.utils.ColorPrinter;

public interface Menu {
    /**
     * Método auxiliar mostrar as opções do menu
     * @param id número da opção
     * @param opcao descrição da opção
     */
    default void printOpcao(String id, String opcao){
        ColorPrinter.printVerde(id);
        System.out.print(" - " + opcao);
        System.out.println();
    }
}
