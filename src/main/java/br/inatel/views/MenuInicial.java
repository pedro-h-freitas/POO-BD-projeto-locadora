package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Menu Principal, faz login, se cadastra como cliente, fecha o programa
 */
public class MenuInicial {
    /**
     * Exibe o Menu Principal
     * Chama Tela de Login
     * Chama Tela de Cadastro
     * @return boolean var (true: roda novamente | false: encerra o programa)
     */
    public static boolean render() {
        int opcao;

        System.out.println("------------ Menu Inicial -------------");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Fazer Cadastro (cliente)");
        System.out.println("0 - Finalizar o programa");
        System.out.println("---------------------------------------");
        System.out.print("Opção: ");

        opcao = Main.sc.nextInt();
        Main.sc.nextLine();

        switch (opcao){
            case 1:
                TelaLogin.render();
                break;
            case 2:
                TelaCadastro.render();
                break;
            case 0:
                return false;
            default:
                System.out.println("!!!!! Opção Inválida !!!!!");
                System.out.print("Aperte [ENTER] para continuar");
                Main.sc.nextLine();
                break;
        }

        return true;
    }
}
