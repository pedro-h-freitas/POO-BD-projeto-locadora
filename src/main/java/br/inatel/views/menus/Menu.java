package br.inatel.views.menus;

import br.inatel.Main;
import br.inatel.views.Tela;
import br.inatel.views.utils.ColorPrinter;

public abstract class Menu extends Tela {
    /**
     * Método auxiliar mostrar as opções do menu
     * @param id número da opção
     * @param opcao descrição da opção
     */
    protected void printOpcao(String id, String opcao){
        printVerde(id);
        System.out.print(" - ");
        printAmarelo(opcao);
        System.out.println();
    }

    protected void printOpcaoInvalida() {
        printVermelho("Opção Inválida\n");
    }
}
