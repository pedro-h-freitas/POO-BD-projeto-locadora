package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.menus.MenuInicial;
import br.inatel.views.menus.Menu;
import java.util.Scanner;

public class Main {
    /**
     * contexto da sessão atual
     */
    public static Context context = new Context();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu;
        boolean run = true;
        // loop de execução
        menu = new MenuInicial();
        System.out.println("----- Bem vindo à locadora POO-BD -----");
        while (run) {
            run = menu.render();
        }
        System.out.println("--------- Programa Finalizado ---------");

        sc.close();
    }
}