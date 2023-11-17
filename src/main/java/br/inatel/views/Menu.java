package br.inatel.views;

public interface Menu {
    /**
     * Método auxiliar mostrar as opções do menu
     * @param id número da opção
     * @param opcao descrição da opção
     */
    default void printOpcao(String id, String opcao){
        Tela.printVerde(id);
        System.out.print(" - " + opcao);
        System.out.println();
    }
}
