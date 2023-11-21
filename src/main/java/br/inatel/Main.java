package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.*;
import br.inatel.views.cliente.MenuCliente;

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
/*

        menu = new MenuCliente();

        context.setUserId(201);
        context.setUserType(Context.CLIENTE);
        context.setLocadoraId(1);

        while (run) {
            run = menu.render();
        }
*/

        sc.close();
    }
}