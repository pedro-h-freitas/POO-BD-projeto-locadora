package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.menus.MenuInicial;
import br.inatel.views.menus.Menu;
import br.inatel.views.menus.funcionario.MenuFuncionario;

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
/*
        menu = new MenuInicial();
        System.out.println("----- Bem vindo à locadora POO-BD -----");
        while (run) {
            run = menu.render();
        }
        System.out.println("--------- Programa Finalizado ---------");
*/

        menu = new MenuFuncionario();

        context.setUserId(101);
        context.setUserType(Context.CLIENTE);
        context.setLocadoraId(1);

        while (run) {
            run = menu.render();
        }

        sc.close();
    }
}