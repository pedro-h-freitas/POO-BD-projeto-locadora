package br.inatel.views;

import br.inatel.Main;

/**
 * Tela do Menu Principal, faz login, se cadastra como cliente, fecha o programa
 */
public class TelaInicial extends Tela implements Menu{
    /**
     * Exibe o Menu Principal
     * Chama Tela de Login
     * Chama Tela de Cadastro
     * @return boolean var (true: roda novamente | false: encerra o programa)
     */
    public boolean render() {
        int opcao;

        System.out.println("------------ Menu Inicial -------------");
        printOpcao("1", "Fazer Login");
        printOpcao("2", "Fazer Cadastro (cliente)");
        printOpcao("0", "Finalizar o programa");
        System.out.println("---------------------------------------");

        opcao = intInput("Opção: ");

        switch (opcao){
            case 1:
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.render();
                break;
            case 2:
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.render();
                break;
            case 0:
                return false;
            default:
                printVermelho("""
                        Opção Inválida
                        Aperte [ENTER] para continuar
                        """);
                Main.sc.nextLine();
                break;
        }

        return true;
    }
}
