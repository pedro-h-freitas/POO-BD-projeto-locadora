package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.*;

import java.util.Scanner;

public class Main {
    /**
     * contexto da sessão atual
     */
    public static Context context = new Context();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MenuInicial menuInicial = new MenuInicial();
        boolean run = true;
/*
        // loop de execução
        System.out.println("----- Bem vindo à POO-BD locadora -----");
        while (run) {
            run = menuInicial.render();
        }
        System.out.println("--------- Programa Finalizado ---------");
        */

        Menu menu = new MenuCliente();

        context.setUserId(205);
        context.setUserType(Context.CLIENTE);
        context.setLocadoraId(-1);

        while (run) {
            run = menu.render();
        }

        sc.close();
    }
}