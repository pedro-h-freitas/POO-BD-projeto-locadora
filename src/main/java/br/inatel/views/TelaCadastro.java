package br.inatel.views;

import br.inatel.Main;
import br.inatel.controllers.CadastroController;

/**
 * Tela de cadastro, cadastra cliente, funcionario ou gerente
 */
public class TelaCadastro {
    /**
     * Exibe a tela de Cadastro
     */
    public static void render(){
        // TODO fazer validação dos dados
        String nome, cpf, senha, endereco, telefone, email;
        CadastroController c = new CadastroController();

        System.out.println("-------------- CADASTRO ---------------");

        nome = inputCampoObrigatorio("Nome");
        cpf = inputCampoObrigatorio("Cpf");
        senha = inputCampoObrigatorio("Senha");

        while (true) {
            endereco = inputCampoOpcional("Endereco");
            telefone = inputCampoOpcional("Telefone");
            email = inputCampoOpcional("Email");

            if (!(endereco == null && telefone == null && email == null))
                break;

            System.out.println("Insira pelo menos uma forma de contato");
        }

        if (c.cadastroCliente(nome, cpf, senha, endereco, telefone, email)) {
            TelaCliente.render();
        } else {
            System.out.println("Cadastro falhou");
        }
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private static String inputCampoObrigatorio(String nomeCampo) {
        String campo;

        System.out.print(nomeCampo + ": ");
        campo = Main.sc.nextLine();
        while (campo.isEmpty()) {
            System.out.println("CAMPO OBRIGATÓRIO");

            System.out.print(nomeCampo + ": ");
            campo = Main.sc.nextLine();
        }

        return campo;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private static String inputCampoOpcional(String nomeCampo) {
        String campo;

        System.out.print(nomeCampo + " (opcional): ");
        campo = Main.sc.nextLine();

        if (campo.isEmpty()) {
            campo = null;
        }

        return campo;
    }
}
