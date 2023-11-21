package br.inatel.views;

import br.inatel.Main;
import br.inatel.views.utils.ColorPrinter;

public abstract class Menu extends Tela{
    /**
     * Método auxiliar mostrar as opções do menu
     * @param id número da opção
     * @param opcao descrição da opção
     */
    protected void printOpcao(String id, String opcao){
        ColorPrinter.printVerde(id);
        System.out.print(" - " + opcao);
        System.out.println();
    }

    protected void printOpcaoInvalida() {
        printVermelho("Opção Inválida\n");
    }
}
