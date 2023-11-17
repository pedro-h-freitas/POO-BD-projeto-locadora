package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.MenuInicial;

import java.util.Scanner;

public class Main {
    /**
     * contexto atual da sessão
     */
    public static Context context = new Context();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        // loop de execução
        System.out.println("----- Bem vindo à POO-BD locadora -----");
        while (run) {
            run = MenuInicial.render();
        }
        System.out.println("--------- Programa Finalizado ---------");
        sc.close();
    }
}