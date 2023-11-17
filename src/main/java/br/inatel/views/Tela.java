package br.inatel.views;

import br.inatel.Main;

/**
 * Classe abstrata para toda Tela
 */
public abstract class Tela {
    /**
     * Método abstrado para exibir uma Tela
     * @return (true: renderizar novamente | false: encerrar execução)
     */
    protected abstract boolean render();

    /**
     * Mostra um texto em azul
     * @param label texto a ser exibido
     */
    protected static void printAzul(String label) {
        System.out.print("\u001B[34m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em azul
     * @param label texto a ser exibido
     */
    protected static void printCiano(String label) {
        System.out.print("\u001B[36m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em vermelho
     * @param label texto a ser exibido
     */
    protected static void printVermelho(String label) {
        System.out.print("\u001B[31m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em verde
     * @param label texto a ser exibido
     */
    protected static void printVerde(String label){
        System.out.print("\u001B[32m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em amarelo
     * @param label texto a ser exibido
     */
    protected static void printAmarelo(String label){
        System.out.print("\u001B[33m" + label + "\u001B[0m");
    }

    /**
     * Mostra um Input de string
     * @param label texto a ser exibido
     */
    protected String stringInput(String label) {
        printAzul(label);
        return Main.sc.nextLine();
    }

    /**
     * Mostra um Input de int
     * @param label texto a ser exibido
     */
    protected Integer intInput(String label) {
        Integer i = null;
        try{
            i = Integer.parseInt(stringInput(label));
        } catch (Exception e) {
            printVermelho("Insira um número");
        }
        return i;
    }

}
