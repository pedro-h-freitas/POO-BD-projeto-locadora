package br.inatel.views.utils;

public class ColorPrinter {

    /**
     * Mostra um texto em azul
     * @param label texto a ser exibido
     */
    public static void printAzul(String label) {
        System.out.print("\u001B[34m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em azul
     * @param label texto a ser exibido
     */
    public static void printCiano(String label) {
        System.out.print("\u001B[36m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em vermelho
     * @param label texto a ser exibido
     */
    public static void printVermelho(String label) {
        System.out.print("\u001B[31m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em verde
     * @param label texto a ser exibido
     */
    public static void printVerde(String label){
        System.out.print("\u001B[32m" + label + "\u001B[0m");
    }

    /**
     * Mostra um texto em amarelo
     * @param label texto a ser exibido
     */
    public static void printAmarelo(String label){
        System.out.print("\u001B[33m" + label + "\u001B[0m");
    }

    public static void printErro(Exception e) {
        printVermelho("Erro: " + e.getMessage() + '\n');
        e.getStackTrace();
    }

}
