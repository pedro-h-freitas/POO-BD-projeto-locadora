package br.inatel.views.menus;

import br.inatel.views.Tela;
import br.inatel.views.TelaLogin;
import br.inatel.views.forms.clientes.FormCadastroCliente;

/**
 * Tela do Menu Principal, faz login, se cadastra como cliente, fecha o programa
 */
public class MenuInicial extends Menu {
    /**
     * Exibe o Menu Principal
     * Chama Tela de Login
     * Chama Tela de Cadastro
     * @return boolean var (true: roda novamente | false: encerra o programa)
     */
    public boolean render() {
        int opcao;

        Tela tela = null;

        System.out.println("------------ Menu Inicial -------------");
        printOpcao("1", "Fazer Login");
        printOpcao("2", "Fazer Cadastro (cliente)");
        printOpcao("0", "Finalizar o programa");
        System.out.println("---------------------------------------");

        opcao = intInput();

        switch (opcao){
            case 1:
                tela = new TelaLogin();
                break;
            case 2:
                tela = new FormCadastroCliente();
                break;
            case 0:
                return false;
            default:
                printOpcaoInvalida();
                break;
        }

        if (tela != null) tela.render();

        return true;
    }
}
