package br.inatel.views;

import br.inatel.Main;

public abstract class Tela {
    protected abstract boolean render();

    protected void printAzul(String label) {
        System.out.print("\u001B[34m" + label + "\u001B[0m");
    }

    protected void printVermelho(String label) {
        System.out.print("\u001B[31m" + label + "\u001B[0m");
    }

    protected void printVerde(String label){
        System.out.print("\u001B[32m" + label + "\u001B[0m");
    }

    protected void printAmarelo(String label){
        System.out.print("\u001B[33m" + label + "\u001B[0m");
    }

    protected String stringInput(String label) {
        printAzul(label);
        return Main.sc.nextLine();
    }

    protected int intInput(String label) {
        return Integer.parseInt(stringInput(label));
    }

}
