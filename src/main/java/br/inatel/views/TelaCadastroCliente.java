package br.inatel.views;

import br.inatel.controllers.CadastroController;

/**
 * Tela de cadastro, cadastra cliente, funcionario ou gerente
 */
public class TelaCadastroCliente extends Tela{
    /**
     * Exibe a tela de Cadastro
     */
    @Override
    public boolean render(){
        // TODO fazer validação dos dados
        String nome, cpf, senha, endereco, telefone, email;
        CadastroController controller = new CadastroController();

        Menu menu;
        boolean run = true;

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

            printAmarelo("Insira pelo menos uma forma de contato\n");
        }

        int idClienteNovo = controller.cadastroCliente(nome, cpf, senha, endereco, telefone, email);

        if (idClienteNovo == -1) {
            printVermelho("Cadastro falhou\n");
            return false;
        }

        printVerde("Usuario Cadastrado com sucesso\nID:");
        printAzul(idClienteNovo + "\n");

        return true;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private String inputCampoObrigatorio(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + ": ");
        while (campo.isEmpty()) {
            printVermelho("CAMPO OBRIGATÓRIO\n");

            campo = stringInput(nomeCampo + ": ");
        }

        return campo;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private String inputCampoOpcional(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + " (opcional): ");
        if (campo.isEmpty()) {
            campo = null;
        }

        return campo;
    }
}
