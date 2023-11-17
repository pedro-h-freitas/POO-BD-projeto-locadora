package br.inatel;

import br.inatel.controllers.Context;
import br.inatel.views.TelaCliente;

import java.util.Scanner;

public class Main {
    /**
     * contexto da sessão atual
     */
    public static Context context = new Context();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*TelaInicial telaInicial = new TelaInicial();
        boolean run = true;

        // loop de execução
        System.out.println("----- Bem vindo à POO-BD locadora -----");
        while (run) {
            run = telaInicial.render();
        }
        System.out.println("--------- Programa Finalizado ---------");
        sc.close();

         */
        TelaCliente telaCliente = new TelaCliente();

        context.setUserId(201);
        context.setUserType(Context.CLIENTE);
        context.setLocadoraId(-1);

        telaCliente.render();
    }
}