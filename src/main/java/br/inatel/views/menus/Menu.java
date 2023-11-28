package br.inatel.views.menus;

import br.inatel.views.Tela;

/**
 * Classe abstrata para todoso os Menus
 */
public abstract class Menu extends Tela {

    /**
     * Método para mostrar as opções do menu
     * @param id número da opção
     * @param opcao descrição da opção
     */
    protected void printOpcao(String id, String opcao){
        printVerde(id);
        System.out.print(" - ");
        printAmarelo(opcao);
        System.out.println();
    }

    /**
     * Método para mostrar a mensagem padrão de opção inávlida
     */
    protected void printOpcaoInvalida() {
        printVermelho("Opção Inválida\n");
    }
}
